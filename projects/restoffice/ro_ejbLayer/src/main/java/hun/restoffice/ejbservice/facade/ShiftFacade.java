/**
 *
 */
package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.ShiftConverterLocal;
import hun.restoffice.ejbservice.domain.EmployeeShiftCloseStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.exception.ApplicationError;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.ShiftServiceLocal;
import hun.restoffice.remoteClient.domain.CalendarScheduleStub;
import hun.restoffice.remoteClient.domain.EmployeeShiftStub;
import hun.restoffice.remoteClient.exception.FacadeException;
import hun.restoffice.remoteClient.facade.ShiftFacadeRemote;

/**
 *  Shift business faacade
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/shiftFacade")
public class ShiftFacade implements ShiftFacadeLocal, ShiftFacadeRemote{

    private static final Logger LOG = Logger.getLogger(ShiftFacade.class);
    @EJB
    private ShiftServiceLocal sService;

    @EJB
    private ShiftConverterLocal sConverter;
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.ShiftFacadeLocal#getCalendarSchedule(java.util.Calendar, java.util.Calendar)
     */
    @Override
    public List<CalendarScheduleStub> getCalendarSchedule(final Calendar from, final Calendar to) throws AdaptorException {
        List<CalendarScheduleStub> rtrn = new ArrayList<>();
        try{
            rtrn = sConverter.toSchedule(sService.readCalendarSchedule(from,to));
            return rtrn;
        } catch (PersistenceServiceException e){
            LOG.error(e);
            throw new AdaptorException(ApplicationError.UNEXPECTED, "excepion occured: getCalendarSchedule params "+from+", "+to);
        }

    }
    @Override
    public List<CalendarScheduleStub> getCalendarschedule(final Calendar day) throws FacadeException {
        try {
            return (this.getCalendarSchedule(day,day));
        } catch (AdaptorException e) {
            // TODO Auto-generated catch block
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
    /* (non-Javadoc)
     * @see hun.restoffice.remoteClient.facade.ShiftFacadeRemote#batchShiftClose(java.util.List)
     */
    @Override
    public void batchShiftClose(final List<EmployeeShiftStub> models) throws FacadeException {
        try {
            sService.updateShifts(sConverter.from(models));
        } catch (PersistenceServiceException e) {
            LOG.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.facade.ShiftFacadeLocal#getShiftToClose(java.util.
     * Calendar)
     */
    @Override
    public List<EmployeeShiftCloseStub> getShiftToClose(final Calendar closeDay) throws FacadeException {
        List<EmployeeShiftCloseStub> rtrn = new ArrayList<>();
        try {
            rtrn = sConverter.toShiftClose(sService.readCalendarSchedule(closeDay, closeDay));
        } catch (PersistenceServiceException e) {
            LOG.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
        return rtrn;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * hun.restoffice.ejbservice.facade.ShiftFacadeLocal#batchShiftCloseShift(java.
     * util.List)
     */
    @Override
    public void batchShiftCloseShift(final List<EmployeeShiftCloseStub> models) throws FacadeException {
        try {
            sService.updateShifts(sConverter.fromCloseStub(models));
        } catch (PersistenceServiceException e) {
            LOG.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }


}
