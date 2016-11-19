/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.ArrayList;
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

import hun.restoffice.persistence.entity.employee.Employee;
import hun.restoffice.persistence.entity.employee.EmployeeShift;
import hun.restoffice.persistence.entity.employee.Shift;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * Shift service facade
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/shiftService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ShiftService implements ShiftServiceLocal {

	private static final Logger LOG = Logger.getLogger(ShiftService.class);

	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.ShiftServiceLocal#readCalendarSchedule(java.util.Calendar,
	 * java.util.Calendar)
	 */
	@Override
	public List<Shift> readCalendarSchedule(Calendar from, Calendar to) throws PersistenceServiceException {
		try {
			List<Shift> lst = this.entityManager.createNamedQuery(Shift.GET_SCHEDULE, Shift.class).setParameter(Shift.FROM_DATE, from.getTime())
					.setParameter(Shift.TO_DATE, to.getTime()).getResultList();
			LOG.info(lst.size());
			return lst;
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.ShiftServiceLocal#removeEmployeeFromShift(java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Shift> removeEmployeeFromShift(Employee Employee) throws PersistenceServiceException {
		List<Shift> rtrn = new ArrayList<>();
		try {
			List<EmployeeShift> lstEmpShifts = this.entityManager.createNamedQuery(EmployeeShift.GET_ENTITES, EmployeeShift.class)
					.setParameter(EmployeeShift.EMPLOYEE, Employee).setParameter(EmployeeShift.FROM_DATE, Calendar.getInstance().getTime()).getResultList();
			for (EmployeeShift es : lstEmpShifts) {
				rtrn.add(es.getShift());
				this.entityManager.remove(es);
			}
			return rtrn;
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

}
