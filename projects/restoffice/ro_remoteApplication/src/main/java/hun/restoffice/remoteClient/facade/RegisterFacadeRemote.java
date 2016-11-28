/**
 * 
 */
package hun.restoffice.remoteClient.service;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;

import hun.restoffice.remoteClient.domain.RegisterStub;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Remote
public interface RegisterFacadeRemote {

	/**
	 * @param day
	 * @throws FacadeException 
	 */
	List<RegisterStub> getRegistersToClose(Calendar day) throws FacadeException;


	/**
	 * @param toClose
	 * @throws FacadeException
	 */
	void batchRegisterClose(List<RegisterStub> toClose) throws FacadeException;

}
