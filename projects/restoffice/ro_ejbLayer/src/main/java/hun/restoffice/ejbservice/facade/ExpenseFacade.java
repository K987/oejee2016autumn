/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.ExpenseConverterLocal;
import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.ExpenseServiceLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/expenseFacade")
public class ExpenseFacade implements ExpenseFacadeLocal {

	private static final Logger LOG = Logger.getLogger(ExpenseFacade.class);
	
	@EJB
	private ExpenseConverterLocal eConverter;
	
	@EJB
	private ExpenseServiceLocal eService;
	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.facade.ExpenseFacadeLocal#getAllExpenses()
	 */
	@Override
	public List<ExpenseStub> getAllExpenses()  throws FacadeException {
		List<ExpenseStub> rtrn = new ArrayList<>();
		try {
			rtrn = this.eConverter.to(this.eService.readAll());
			return rtrn;
		} catch (PersistenceServiceException e) {
			throw new FacadeException(e.getLocalizedMessage());
		}
		
	}
	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.facade.ExpenseFacadeLocal#deleteExpense(java.lang.String)
	 */
	@Override
	public void deleteExpense(String docId) throws FacadeException {
		try {
			this.eService.deleteExpense(docId);
		} catch (PersistenceServiceException e) {
			LOG.error(e);
			throw new FacadeException(e.getMessage());
		}
		
	}

}
