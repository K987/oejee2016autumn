/**
 * 
 */
package hun.restoffice.ejbservice.exception;

/**
 * Exception for local clients
 * 
 * @author kalmankostenszky
 *
 */
public class FacadeException extends Exception {

	private static final long serialVersionUID = 1L;

	public FacadeException(String localizedMessage) {
		super(localizedMessage);
	}


	
}
