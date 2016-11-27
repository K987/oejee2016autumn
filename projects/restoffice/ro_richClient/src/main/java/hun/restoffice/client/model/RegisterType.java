/**
 * 
 */
package hun.restoffice.client.model;

/**
 *  
 *
 * @author kalmankostenszky
 */
public enum RegisterType {

	CASH("pénztárgép"),
	CARD("bankkártya terminál");
	
	private String displayName;

	RegisterType(String name){
		this.displayName = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return displayName;
	}
}

