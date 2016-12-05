/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.ExpsnseStub;



/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface ExpenseFacadeLocal {

	/**
	 * @return
	 */
	List<ExpsnseStub> getAllExpenses();

}
