/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.AmbiguousResolutionException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.financialTransaction.CostCenter;
import hun.restoffice.persistence.entity.financialTransaction.ExpType;
import hun.restoffice.persistence.entity.financialTransaction.Expense;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/expenseService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ExpenseService implements ExpenseServiceLocal {

	private static final Logger LOG = Logger.getLogger(ExpenseService.class);

	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;
	
	@EJB
	private FinanceMiscServiceLocal fService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.ExpenseServiceLocal#readAll()
	 */
	@Override
	public List<Expense> readAll() throws PersistenceServiceException {
		try {

			return this.entityManager.createNamedQuery(Expense.FIND_ALL, Expense.class).getResultList();
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown exception while retrieving all expenses");

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.ExpenseServiceLocal#deleteExpense(java.lang.String)
	 */
	@Override
	public void deleteExpense(String docId) throws PersistenceServiceException {
		Expense toDelete = readById(docId);
		try {
			this.entityManager.remove(toDelete);
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown error while deleting docId: " + docId);
		}

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Expense readById(String docId) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(Expense.READ_BY_DOC_ID, Expense.class).setParameter(Expense.DOC_ID, docId.trim().toLowerCase())
					.getSingleResult();
		} catch (AmbiguousResolutionException e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.AMBIGOUS_RESULT, "multiple matching for docId: " + docId);
		} catch (NoResultException e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.NOT_EXISTS, "no matching for docId: " + docId);
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unkonow error during querying for docId: " + docId);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.ExpenseServiceLocal#readFiltered(java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, hun.restoffice.persistence.entity.financialTransaction.PaymentMethod, java.lang.Boolean)
	 */
	@Override
	public List<Expense> readFiltered(Integer partnerId, Integer costCenterId, Integer costTypeId, int pm, Boolean isPayed)
			throws PersistenceServiceException {
		int payed = isPayed == null ? 0 : (isPayed == Boolean.TRUE ? 1 : -1);
		LOG.info("readFiltered invoked with params: [ partnerID: "+partnerId+", "+"costCenterId: "+costCenterId+", "+"costTypeId: "+costTypeId+", "+"PaymentMethod: "+pm+", "+"isPayed: "+isPayed+"]");
		try {
			return this.entityManager.createNamedQuery(Expense.READ_FILTERED, Expense.class)
					.setParameter(Expense.PARTNER_ID, partnerId)
					.setParameter(Expense.COSTCENTER_ID, costCenterId)
					.setParameter(Expense.COSTTYPE_ID, costTypeId)
					.setParameter(Expense.PAYMENT_METHOD, pm)
					.setParameter(Expense.IS_PAYED, isPayed)
					.getResultList();
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "error occured while reading expenses");
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.ExpenseServiceLocal#add(hun.restoffice.persistence.entity.financialTransaction.Expense)
	 */
	@Override
	public void add(Expense expense) throws PersistenceServiceException {
		if (this.count(expense.getDocId()) == 0){
			expense.setLastModifiedAt(Calendar.getInstance().getTime());
			this.insert(expense);
		} else {
			this.update(expense);
		}
		
	}

	/**
	 * @param expense
	 * @throws PersistenceServiceException 
	 */
	private void update(Expense expense) throws PersistenceServiceException {
		Expense entity = this.readById(expense.getDocId());
		entity.update(expense);
		this.entityManager.flush();
	}

	/**
	 * @param expense
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private void insert(Expense expense) throws PersistenceServiceException{
		CostCenter cc = this.fService.readCostCenterByName(expense.getCostCenterName());
		ExpType ep = this.fService.readExpTypeByName(expense.getCostTypeName());
		
		expense.setCostCenter(cc);
		expense.setExpType(ep);
		try{
		this.entityManager.persist(expense);
		} catch (Exception e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/**
	 * @param docId
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private int count(String docId) throws PersistenceServiceException{
		try{
			return this.entityManager.createNamedQuery(Expense.COUNT, Long.class).setParameter(Expense.DOC_ID, docId.trim().toLowerCase()).getSingleResult().intValue();
		} catch (Exception e){
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

}
