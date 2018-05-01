package hun.restoffice.ejbservice.facade;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@Local
public interface RegisterFacadeLocal {

    List<RegisterCloseStub> getRegistersToClose(Calendar day) throws FacadeException;

    void batchRegisterClose(List<RegisterCloseStub> toClose) throws FacadeException;
}
