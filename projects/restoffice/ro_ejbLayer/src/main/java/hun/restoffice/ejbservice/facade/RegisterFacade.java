/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.RegisterConverterLocal;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.RegisterServiceLocal;
import hun.restoffice.remoteClient.domain.RegisterStub;
import hun.restoffice.remoteClient.service.FacadeException;
import hun.restoffice.remoteClient.service.RegisterFacadeRemote;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/registerFacade")
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
		LOG.info("getRegistersToClose invoked");
		List<RegisterStub> rtrn = new ArrayList<>();
		try {
			rtrn = this.rConverter.to(this.rService.readRegisterClose(day));
			if (rtrn.isEmpty()) {
				rtrn = this.rConverter.to(this.rService.readAllWithLastClose());
				for (RegisterStub registerStub : rtrn) {
					registerStub.setCloseNo(registerStub.getCloseNo() + 1);
					registerStub.setDate(day);
					registerStub.setAmt(0);
				}
			}
			return rtrn;
		} catch (PersistenceServiceException e) {
			LOG.error(e);
			throw new hun.restoffice.remoteClient.service.FacadeException(e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.remoteClient.service.RegisterFacadeRemote#createRegisterClose(java.util.List)
	 */
	@Override
	public void batchRegisterClose(List<RegisterStub> toClose) throws FacadeException {
		LOG.info("createRegisterClose invoked" );
		for (RegisterStub registerStub : toClose) {
			try {
				this.rService.createRegisterClose(registerStub.getId(), registerStub.getDate().getTime(), registerStub.getCloseNo(), registerStub.getAmt());
			} catch (PersistenceServiceException e) {
				LOG.error(e);
				throw new FacadeException(e.getLocalizedMessage());
			}
		}
	}
}
