/**
 * 
 */
package hun.restoffice.client.controller;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface WizardElement {
	
	boolean onNext();
	
	boolean onPrevious();
	
	void onCancel();
	
	void onSend();
	
	//void onLoad(LocalDate date);
}
