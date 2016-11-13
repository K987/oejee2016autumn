/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.AmbiguousResolutionException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.employee.Employee;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless
public class EmployeeService implements EmployeeServiceLocal {

	private static final Logger LOG = Logger.getLogger(PartnerService.class);

	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.EmployeeServiceLocal#readAll()
	 */
	@Override
	public List<Employee> readAll() throws PersistenceServiceException {
		List<Employee> rtrn = null;
		try {
			rtrn = this.entityManager.createNamedQuery(Employee.FIND_ALL).getResultList();
			return rtrn;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.EmployeeServiceLocal#create()
	 */
	@Override
	public Employee create(Employee employee) throws PersistenceServiceException {
		try {
			Employee rtrn = this.entityManager.merge(employee);
			this.entityManager.flush();
			return rtrn;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.persistence.service.EmployeeServiceLocal#queryEmpSchedule(java.lang.String,
	 * java.util.Calendar, java.util.Calendar)
	 */
	@Override
	public Employee queryEmpSchedule(String name, Calendar from, Calendar to) throws PersistenceServiceException{
		try {
			return this.entityManager.createNamedQuery(Employee.GET_EMPLOYEE_SCHEDULE, Employee.class).setParameter(Employee.NAME, name)
					.setParameter(Employee.START_DATE, from.getTime()).setParameter(Employee.END_DATE, to.getTime()).getSingleResult();
		} catch (AmbiguousResolutionException e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.AMBIGOUS_RESULT, "multiple matching for name: "+ name);
		} catch (NoResultException e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.NOT_EXISTS, "no matching for name: "+name);
		} catch (Exception e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unkonow error during querying for [name: "+name+" dates between: "+from+" - "+to);
		}
	}

}
