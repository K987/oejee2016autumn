/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.testng.log4testng.Logger;

import hun.restoffice.ejbservice.converter.RegisterConverterLocal;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.RegisterServiceLocal;
import hun.restoffice.remoteClient.domain.RegisterStub;
import hun.restoffice.remoteClient.service.RegisterFacadeRemote;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless
public class RegisterFacade implements RegisterFacadeRemote {

	private static final Logger LOG = Logger.getLogger(RegisterFacade.class);
	
	@EJB
	private RegisterServiceLocal rService;
	
	@EJB
	private RegisterConverterLocal rConverter;

			
			
	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.remoteClient.service.RegisterFacadeRemote#getRegistersToClose(java.util.Calendar)
	 */
	@Override
	public List<RegisterStub> getRegistersToClose(Calendar day) throws hun.restoffice.remoteClient.service.FacadeException {
		List<RegisterStub> rtrn = new ArrayList<>();
		
		try {
			rtrn = this.rConverter.to(this.rService.readRegisterClose(day));
			if (rtrn.isEmpty()){
				rtrn = this.rConverter.to(this.rService.readAllWithLastClose());
				for (RegisterStub registerStub : rtrn) {
					registerStub.setCloseNo(registerStub.getCloseNo() + 1);
					registerStub.setAmt(new BigDecimal(0));
				}
			}
			return rtrn;
		} catch (PersistenceServiceException e) {
			LOG.error(e);
			throw new hun.restoffice.remoteClient.service.FacadeException(e.getLocalizedMessage());
		}
	}

}
