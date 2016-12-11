/**
 * 
 */
package hun.restoffice.remoteClient.domain;

/**
 *  
 *
 * @author kalmankostenszky
 */
public enum DocTypeStub {

	EXTERNAL("külső"),
	INTERNAL("belső");
	
	
	private final String description;

	private DocTypeStub(String description){
		this.description = description;
		
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
