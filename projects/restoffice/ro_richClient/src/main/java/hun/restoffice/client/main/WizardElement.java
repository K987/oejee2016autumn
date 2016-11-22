/**
 * 
 */
package hun.restoffice.client.main;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface WizardElement {

	void onNext();
	
	void onPrevious();
	
	void onCancel();
	
	void onSend();
}
