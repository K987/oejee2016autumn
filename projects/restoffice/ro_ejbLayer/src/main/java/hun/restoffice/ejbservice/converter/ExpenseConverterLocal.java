/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.persistence.entity.financialTransaction.Expense;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface ExpenseConverterLocal {

	/**
	 * @param readAll
	 * @return
	 */
	List<ExpenseStub> to(List<Expense> readAll);

}
