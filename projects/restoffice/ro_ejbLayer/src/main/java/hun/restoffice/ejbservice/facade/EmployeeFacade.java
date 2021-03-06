/**
 *
 */
package hun.restoffice.ejbservice.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.EmployeeConverterLocal;
import hun.restoffice.ejbservice.converter.ShiftConverterLocal;
import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.domain.ShiftStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.exception.ApplicationError;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.EmployeeServiceLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 * Employee business facade
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/employeeFacade")
public class EmployeeFacade implements EmployeeFacadeLocal {

    private static Logger LOG = Logger.getLogger(EmployeeFacade.class);

    @EJB
    private EmployeeServiceLocal eService;

    @EJB
    private EmployeeConverterLocal eConverter;

    @EJB
    private ShiftConverterLocal sConverter;

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#getAllEmployees()
     */
    @Override
    public List<EmployeeStub> getAllEmployees() throws AdaptorException {
        if (LOG.isDebugEnabled())
            LOG.debug("getAllEmployess invoked");
        try {
            final List<EmployeeStub> rtrn = eConverter.to(eService.readAll());
            return rtrn;
        } catch (PersistenceServiceException e) {
            throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#addEmployee(hun.restoffice.ejbservice.domain.EmployeeStub)
     */
    @Override
    public EmployeeStub addEmployee(final EmployeeStub employee) throws AdaptorException {
        if (LOG.isDebugEnabled())
            LOG.debug("addEmpolyee invoked w/ param: [employee: " + employee + "]");
        try {
            return eConverter.to(eService.create(eConverter.from(employee)));
        } catch (PersistenceServiceException e) {
            switch (e.getType()) {
                case EXISTS_ALREADY:
                    throw new AdaptorException(ApplicationError.EXISTS_ALREADY, e.getMessage());
                default:
                    throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#removeEmployee(java.lang.String)
     */
    @Override
    public List<ShiftStub> removeEmployee(final Integer employeeId) throws FacadeException {
        if (LOG.isDebugEnabled())
            LOG.debug("removeEmployee invoked w/ param " + employeeId);
        try {
            return sConverter.to(eService.deleteEmployee(employeeId));
        } catch (Exception e) {
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#getEmployeeSchedule(java.lang.String,
     * java.util.Calendar, java.util.Calendar)
     */
    @Override
    public EmployeeScheduleStub getEmployeeSchedule(final String name, final Calendar from, final Calendar to) throws AdaptorException {
        if (LOG.isDebugEnabled())
            LOG.debug("getEmployeeSchedule invoked w/ param: [employee name: " + name + ", from: " + from + ", to: " + to + "]");
        try {
            return eConverter.toSchedule(eService.queryEmpSchedule(name, from, to));
        } catch (PersistenceServiceException e) {
            throw new AdaptorException(ApplicationError.UNEXPECTED, "not implemented");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#updateEmployee(hun.restoffice.ejbservice.domain.
     * EmployeeStub)
     */
    @Override
    public EmployeeStub updateEmployee(final EmployeeStub employee) throws AdaptorException {
        if (LOG.isDebugEnabled())
            ;
        LOG.debug("updateEmployee invoked w/ params: " + employee);
        try {
            return eConverter.to(eService.updateEmployee(eConverter.from(employee)));
        } catch (PersistenceServiceException e) {
            switch (e.getType()) {
                case AMBIGOUS_RESULT:
                    throw new AdaptorException(ApplicationError.UNEXPECTED_RESULT, e.getMessage());
                case NOT_EXISTS:
                    throw new AdaptorException(ApplicationError.NOT_EXISTS, e.getMessage());
                default:
                    throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.facade.EmployeeFacadeLocal#getEmployee(java.lang.
     * Integer)
     */
    @Override
    public EmployeeStub getEmployee(final Integer employeeId) throws FacadeException {
        try {
            return eConverter.to(eService.read(employeeId));
        } catch (PersistenceServiceException e) {
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

}
