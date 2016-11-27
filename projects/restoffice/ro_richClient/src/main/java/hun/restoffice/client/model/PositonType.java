/**
 * 
 */
package hun.restoffice.client.model;

/**
 *  
 *
 * @author kalmankostenszky
 */
public enum PositonType {

	WAITER("felszolgáló"),
	BARTENDER("báros"),
	CHEF("szakács");
	
	private String displayName;

	/**
	 * 
	 */
	private PositonType(String displayName) {
		this.displayName = displayName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.displayName;
	}
}
