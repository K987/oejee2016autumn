/**
 * 
 */
package hu.restoffice.restService.partner;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;

/**
 * Impelentation class of REST services on partner
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
	 * @see hu.restoffice.restService.partner.PartnerRestService#getPartnerContact( java.lang.String)
	 */
	@Override
	public PartnerContactStub getPartnerContact(String partnerName) throws AdaptorException {
		LOG.info("Get partner contact invoked. Name: " + partnerName);
		return this.facade.getPartnerContact(partnerName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.partner.PartnerRestService#getAllPartnerContacts()
	 */
	@Override
	public List<PartnerStub> getAllPartnerContacts() throws AdaptorException {
		LOG.info("Get all partners invoked");
		List<PartnerStub> rtrn = this.facade.gatAllPartnerContact();
		return rtrn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.partner.PartnerRestService#deleteUnusedPartners()
	 */
	@Override
	public List<PartnerStub> deleteUnusedPartners() throws AdaptorException {
		LOG.info("delete unused partners invoked");
		return this.facade.deleteUnusedPartners();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.partner.PartnerRestService#addPartner()
	 */
	@Override
	public PartnerStub addPartner(PartnerStub partner) throws AdaptorException {
		LOG.info("add new partner invoked");
		return this.facade.addPartner(partner);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.restoffice.restService.partner.PartnerRestService#updatePartner()
	 */
	@Override
	public PartnerStub updatePartner(PartnerStub partner) throws AdaptorException {
		LOG.info("update partner invoked");
		return this.facade.updatePartner(partner);
	}

}
