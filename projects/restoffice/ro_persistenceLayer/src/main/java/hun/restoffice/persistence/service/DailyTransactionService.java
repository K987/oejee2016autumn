/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.dailyTransaction.DailyIncome;
import hun.restoffice.persistence.entity.employee.EmployeeShift;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DailyTransactionService implements DailyTransactionServiceLocal {

	private static final Logger LOG = Logger.getLogger(DailyTransactionService.class);
	
	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;

	@EJB
	private ShiftServiceLocal sService;
	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.DailyTransactionServiceLocal#createDailyTransactionBatch(java.util.List)
	 */
	@Override
	public void createDailyTransactionBatch(List<DailyIncome> incomes) throws PersistenceServiceException {
		for (DailyIncome dailyIncome : incomes) {
			EmployeeShift employeeShift = sService.readByRowId(dailyIncome.getRowId());
			dailyIncome.setEmployeeShift(employeeShift);
			try{
				this.entityManager.persist(dailyIncome);
			} catch (Exception e){
				LOG.error(e);
				throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "Unknown exception occured during persisting dailyIncome: "+dailyIncome.getRowId());
			}
		}
	}
}
