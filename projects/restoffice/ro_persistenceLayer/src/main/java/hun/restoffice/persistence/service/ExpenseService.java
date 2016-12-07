/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

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
		try{
			this.entityManager.remove(toDelete);
		} catch(Exception e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown error while deleting docId: "+docId);
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	private Expense readById(String docId) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(Expense.READ_BY_DOC_ID, Expense.class).setParameter(Expense.DOC_ID, docId.trim().toLowerCase()).getSingleResult();
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

}
