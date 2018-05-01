package hun.restoffice.ejbservice.facade;

import java.util.Calendar;
import java.util.List;

import hun.restoffice.ejbservice.domain.EmployeeShiftCloseStub;
import hun.restoffice.remoteClient.domain.DailyTransactionStub;
import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
public interface DailyCloseFacadeLocal {

    List<RegisterCloseStub> getRegistersToClose() throws FacadeException;

    List<EmployeeShiftCloseStub> getEmployeeShiftToClose() throws FacadeException;

    void addRegisterClose(RegisterCloseStub stub);

    void addEmployeeShift(EmployeeShiftCloseStub stub);

    void addDailyTransaction(DailyTransactionStub stub);

    void closeDay() throws FacadeException;

    /**
     * @param day
     */
    void setCloseDay(Calendar day);

    Calendar getCloseDay();

    /**
     *
     */
    void remove();

    public boolean areRegistersClosed();
}