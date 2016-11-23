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

	void onNext();
	
	void onPrevious();
	
	void onCancel();
	
	void onSend();
	
	void onLoad();
}
