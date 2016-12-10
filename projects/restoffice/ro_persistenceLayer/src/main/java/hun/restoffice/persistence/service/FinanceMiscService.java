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

import hun.restoffice.persistence.entity.financialTransaction.CostCenter;
import hun.restoffice.persistence.entity.financialTransaction.ExpType;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/financeMiscService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FinanceMiscService implements FinanceMiscServiceLocal {

	
	private static final Logger LOG = Logger.getLogger(FinanceMiscService.class);

	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.FinanceMiscServiceLocal#readAllCostCenter()
	 */
	@Override
	public List<CostCenter> readAllCostCenter() throws PersistenceServiceException {
		try{
			return this.entityManager.createNamedQuery(CostCenter.FIND_ALL, CostCenter.class).getResultList();
		} catch (Exception e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown error while retrieving cost centers");
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.FinanceMiscServiceLocal#readAllExpenseType()
	 */
	@Override
	public List<ExpType> readAllExpenseType() throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(ExpType.FIND_ALL).getResultList();
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown error while retrieving expense types");
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.FinanceMiscServiceLocal#readCostCenterByName(java.lang.String)
	 */
	@Override
	public CostCenter readCostCenterByName(String costCenterName) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(CostCenter.FIND_BY_NAME, CostCenter.class).setParameter(CostCenter.NAME, costCenterName.trim().toLowerCase()).getSingleResult();
		} catch (AmbiguousResolutionException e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.AMBIGOUS_RESULT, "multiple matching for costcenter name: " + costCenterName);
		} catch (NoResultException e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.NOT_EXISTS, "no matching for costcenter name: " + costCenterName);
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unkonow error during querying for costcenter name: " + costCenterName);
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.FinanceMiscServiceLocal#readExpTypeByName(java.lang.String)
	 */
	@Override
	public ExpType readExpTypeByName(String costTypeName) throws PersistenceServiceException {
		try {
			return this.entityManager.createNamedQuery(ExpType.FIND_BY_NAME, ExpType.class).setParameter(ExpType.NAME, costTypeName.trim().toLowerCase()).getSingleResult();
		} catch (AmbiguousResolutionException e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.AMBIGOUS_RESULT, "multiple matching for costtype name: " + costTypeName);
		} catch (NoResultException e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.NOT_EXISTS, "no matching for costtype name: " + costTypeName);
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unkonow error during querying for costtype name: " + costTypeName);
		}
	}
	

}
