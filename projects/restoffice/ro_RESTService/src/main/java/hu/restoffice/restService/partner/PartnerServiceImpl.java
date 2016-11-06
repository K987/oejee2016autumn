/**
 * 
 */
package hu.restoffice.restService.partner;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless
public class PartnerServiceImpl implements PartnerRestService {

	private static final Logger LOG = Logger.getLogger(PartnerServiceImpl.class);

	@EJB
	private PartnerFacadeLocal facade;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.restoffice.restService.partner.PartnerRestService#getPartnerContact(
	 * java.lang.String)
	 */
	@Override
	public PartnerContactStub getPartnerContact(String partnerName) throws AdaptorException{
		LOG.info("Get partner contact invoked. Name: " + partnerName);
		return this.facade.getPartnerContact(partnerName);
	}

}
