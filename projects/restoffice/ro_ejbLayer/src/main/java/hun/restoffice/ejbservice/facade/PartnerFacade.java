/**
 * 
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.PartnerConverterLocal;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.FacadeException;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.PartnerServiceLocal;

/**
 * @author kalmankostenszky
 *
 */
@Stateless(mappedName = "ejb/partnerFacade")
public class PartnerFacade implements PartnerFacadeLocal {

	private static final Logger LOGGER = Logger.getLogger(PartnerFacade.class);

	@EJB
	private PartnerServiceLocal psl;

	@EJB
	private PartnerConverterLocal pcl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hun.restoffice.ejbservice.facade.PartnerFacadeLocal#getPartnersWithName(
	 * java.lang.CharSequence)
	 */
	@Override
	public List<PartnerStub> getPartnersWithName(CharSequence namePart) throws FacadeException {
		LOGGER.info("get partner invoke with name: " + namePart);
		try {
			return this.pcl.toPartnerStubList(this.psl.read(namePart));
		} catch (PersistenceServiceException e) {
			throw new FacadeException(e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#getAllPartners()
	 */
	@Override
	public List<PartnerStub> getAllPartners() throws FacadeException {
		LOGGER.info("get all partner invoke");
		try {
			return this.pcl.toPartnerStubList(this.psl.readAll());
		} catch (PersistenceServiceException e) {
			throw new FacadeException(e.getLocalizedMessage());
		}
	}
}
