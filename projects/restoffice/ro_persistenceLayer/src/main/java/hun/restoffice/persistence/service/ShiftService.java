/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.employee.Shift;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/shiftService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ShiftService implements ShiftServiceLocal {
	
	private static final Logger LOG = Logger.getLogger(ShiftService.class);
	
	@PersistenceContext(unitName="ro-persistence-unit")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.ShiftServiceLocal#readCalendarSchedule(java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public List<Shift> readCalendarSchedule(Calendar from, Calendar to) throws PersistenceServiceException {
		try{
			return this.entityManager.createNamedQuery(Shift.GET_SCHEDULE, Shift.class).setParameter(Shift.FROM_DATE, from.getTime()).setParameter(Shift.TO_DATE, to.getTime()).getResultList();
		} catch(Exception e){
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown exception");
		}
	}

}
