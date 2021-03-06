/**
 *
 */
package hu.restoffice.restService.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.restoffice.restService.exception.RestError;
import hu.restoffice.restService.param.DateParam;
import hun.restoffice.ejbservice.domain.EmployeeScheduleStub;
import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.domain.ShiftStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.EmployeeFacadeLocal;
import hun.restoffice.remoteClient.facade.RegisterFacadeRemote;

/**
 * An implementation class for EmployeeRestService class
 *
 * @author kalmankostenszky
 */
@Stateless
public class EmployeeRestServiceImpl implements EmployeeRestService {

    private static final Logger LOG = Logger.getLogger(EmployeeRestServiceImpl.class);

    @EJB
    private EmployeeFacadeLocal facade;

    @EJB
    private RegisterFacadeRemote rfacade;

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.restService.service.EmployeeRestService#getAllEmployee()
     */
    @Override
    public List<EmployeeStub> getAllEmployees() throws AdaptorException {
        LOG.info("get all employees invokded");
        return facade.getAllEmployees();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.restService.service.EmployeeRestService#addEmployee(hun.restoffice.ejbservice.domain.EmployeeStub)
     */
    @Override
    public EmployeeStub addEmployee(final EmployeeStub employee) throws AdaptorException {
        LOG.info("add employee invoked w/ param: " + employee);
        return facade.addEmployee(employee);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.restService.service.EmployeeRestService#updateEmployee(hun.restoffice.ejbservice.domain.
     * EmployeeStub)
     */
    @Override
    public EmployeeStub updateEmployee(final EmployeeStub employee) throws AdaptorException {
        LOG.info("update employee invoked w/ param: " + employee);
        return facade.updateEmployee(employee);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.restService.service.EmployeeRestService#removeEmployee(java.lang.String)
     */
    @Override
    public List<ShiftStub> removeEmployee(final String employeeName) throws AdaptorException {
        LOG.info("remove employee invoked w/ param: " + employeeName);
        return null;
        // return this.facade.removeEmployee(employeeName);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.restService.service.EmployeeRestService#getEmployeeSchedule(java.lang.String,
     * hu.restoffice.restService.converter.RESTDate, hu.restoffice.restService.converter.RESTDate)
     */
    @Override
    public EmployeeScheduleStub getEmployeeSchedule(final String name, final DateParam from, final DateParam to) throws AdaptorException, WebApplicationException {
        LOG.info("get employee schedule invoked");
        Calendar f = null;
        Calendar t = null;

        try {
            f = from.getDate() != null ? from.getDate() : Calendar.getInstance();
            if (to.getDate() != null) {
                t = to.getDate();
            } else {
                t = (Calendar) f.clone();
                t.add(Calendar.DAY_OF_YEAR, 14);
            }
        } catch (Exception e) {
            LOG.error(e.getLocalizedMessage());
            throw new WebApplicationException(e, Response.status(400).entity(new RestError(-100, "missing parameter")).build());
        }

        EmployeeScheduleStub rtrn = facade.getEmployeeSchedule(name, f, t);
        Collections.sort(rtrn.getWorkdays());
        return rtrn;
    }
}
