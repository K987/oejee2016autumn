package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.EmployeeShiftCloseStub;
import hun.restoffice.remoteClient.domain.DailyTransactionStub;
import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@Stateful(mappedName = "ejb/DailyCloseFacade")
public class DailyCloseFacade implements DailyCloseFacadeLocal {

    private static final Logger log = Logger.getLogger(DailyCloseFacade.class);

    private List<RegisterCloseStub> registerCloses;
    private List<EmployeeShiftCloseStub> employeeShifts;
    private List<DailyTransactionStub> dailyTransactions;
    Calendar closeDay;
    private boolean registerClosed;

    @EJB
    private RegisterFacadeLocal rFacade;

    @EJB
    private ShiftFacadeLocal sFacade;

    @EJB
    private DailyTransactionFacadeLocal dFacade;

    @Override
    public void setCloseDay(final Calendar day) {
        closeDay = day;
    }

    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal1#getRegistersToClose(java.util.Calendar)
     */
    @Override
    public List<RegisterCloseStub> getRegistersToClose() throws FacadeException {
        if (registerCloses == null) {
            registerCloses = rFacade.getRegistersToClose(closeDay);
            registerClosed = registerCloses.get(0).isClosed();
        }
        return registerCloses;
    }

    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal1#getEmployeeShiftToClose(java.util.Calendar)
     */
    @Override
    public List<EmployeeShiftCloseStub> getEmployeeShiftToClose() throws FacadeException {
        if (employeeShifts == null) {
            employeeShifts = new ArrayList<>();
            employeeShifts = sFacade.getShiftToClose(closeDay);

        }
        return employeeShifts;
    }

    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal1#addRegisterClose(hun.restoffice.remoteClient.domain.RegisterCloseStub)
     */
    @Override
    public void addRegisterClose(final RegisterCloseStub stub) {
        registerCloses.add(stub);
    }

    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal1#addEmployeeShift(hun.restoffice.remoteClient.domain.EmployeeShiftStub)
     */
    @Override
    public void addEmployeeShift(final EmployeeShiftCloseStub stub) {
        employeeShifts.add(stub);
    }

    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal1#addDailyTransaction(hun.restoffice.remoteClient.domain.DailyTransactionStub)
     */
    @Override
    public void addDailyTransaction(final DailyTransactionStub stub) {
        dailyTransactions.add(stub);
    }

    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal1#closeDay()
     */
    @Override
    public void closeDay() throws FacadeException {
        rFacade.batchRegisterClose(registerCloses);
        sFacade.batchShiftCloseShift(employeeShifts);
        dFacade.batchTransactionClose(dailyTransactions);
        dFacade.closeDay(closeDay.getTime());
    }

    @Override
    @Remove
    public void remove() {
        registerCloses = null;
        employeeShifts = null;
        dailyTransactions = null;
        closeDay = null;
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal#getCloseDay()
     */
    @Override
    public Calendar getCloseDay() {
        return closeDay;
    }

    /**
     * @return the registerClosed
     */
    @Override
    public boolean areRegistersClosed() {
        return registerClosed;
    }

    /**
     * @param registerClosed
     *            the registerClosed to set
     */
    public void setRegisterClosed(final boolean registerClosed) {
        this.registerClosed = registerClosed;
    }

}
