/**
 * 
 */
package hun.restoffice.ejbservice.exception;

import hun.restoffice.remoteClient.service.FacadeException;

/**
 * Exception for local clients
 * 
 * @author kalmankostenszky
 *
 */
public class FacadeExceptionLocal extends FacadeException {

	private static final long serialVersionUID = 1L;

	public FacadeExceptionLocal(String localizedMessage) {
		super(localizedMessage);
	}


	
}
