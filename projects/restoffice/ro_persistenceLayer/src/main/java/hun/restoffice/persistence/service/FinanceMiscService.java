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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.financialTransaction.CostCenter;
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

}
