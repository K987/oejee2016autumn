/**
 * 
 */
package hun.restoffice.persistence.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.persistence.entity.dailyTransaction.RegisterClose;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * @author hunkak
 *
 */
@Stateless(mappedName="ejb/registerService")
public class RegisterService implements RegisterServiceLocal {

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.RegisterServiceLocal#readRegisterClose(java.util.Calendar)
	 */
	@Override
	public List<RegisterClose> readRegisterClose(Calendar day) throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.RegisterServiceLocal#readAllWithLastClose()
	 */
	@Override
	public List<RegisterClose> readAllWithLastClose() throws PersistenceServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
