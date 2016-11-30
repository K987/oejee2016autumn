/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.DailyTransactionConverterLocal;
import hun.restoffice.persistence.service.DailyTransactionServiceLocal;
import hun.restoffice.remoteClient.domain.DailyTransactionStub;
import hun.restoffice.remoteClient.exception.FacadeException;
import hun.restoffice.remoteClient.facade.DailyTransactionFacadeRemote;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/dailyTransactionFacade")
public class DailyTransactionFacade implements DailyTransactionFacadeRemote {

	private static final Logger LOG = Logger.getLogger(DailyTransactionFacade.class);
	@EJB
	private DailyTransactionConverterLocal dConverter;
	
	@EJB
	private DailyTransactionServiceLocal dService;
	
	/* (non-Javadoc)
	 * @see hun.restoffice.remoteClient.facade.DailyTransactionFacadeRemote#batchTransactionClose(java.util.List)
	 */
	@Override
	public void batchTransactionClose(List<DailyTransactionStub> stubs) throws FacadeException {
		try{
			this.dService.createDailyTransactionBatch(this.dConverter.from(stubs));
		} catch (Exception e){
			LOG.error(e);
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
	

}
