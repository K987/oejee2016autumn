/**
 * 
 */
package hun.restoffice.ejbservice.event;

import java.io.Serializable;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class DailyCloseEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1071882796382762257L;
	
	public String message;
	
	public DailyCloseEvent(){
		
	}
	
	public DailyCloseEvent(String message){
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("DailyCloseEvent [message=%s]", message);
	}
	
	
}
