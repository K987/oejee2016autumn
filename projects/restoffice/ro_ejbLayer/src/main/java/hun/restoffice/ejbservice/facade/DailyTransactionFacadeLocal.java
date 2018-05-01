package hun.restoffice.ejbservice.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hun.restoffice.remoteClient.domain.DailyTransactionStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@Local
public interface DailyTransactionFacadeLocal {

    public void batchTransactionClose(final List<DailyTransactionStub> stubs) throws FacadeException;

    public void closeDay(final Date day) throws FacadeException;
}
