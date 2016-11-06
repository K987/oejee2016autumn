/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.persistence.entity.partner.Partner;

/**
 * Convert partner entites to stubs
 * 
 * @author kalmankostenszky
 *
 */
@Stateless
public class PartnerConverter implements PartnerConverterLocal {

	private static final Logger LOG = Logger.getLogger(PartnerConverter.class);
	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.PartnerConverterLocal#to(hun.restoffice.persistence.entity.partner.Partner)
	 */
	@Override
	public PartnerStub to(Partner partner) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.PartnerConverterLocal#toPartnerStubList(java.util.List)
	 */
	@Override
	public List<PartnerStub> to(List<Partner> partners) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.PartnerConverterLocal#toContact(hun.restoffice.persistence.entity.partner.Partner)
	 */
	@Override
	public PartnerContactStub toContact(Partner partner) {
		return new PartnerContactStub(partner.getContact());
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.PartnerConverterLocal#toContact(java.util.List)
	 */
	@Override
	public List<PartnerStub> toContact(List<Partner> readAll) {
		List<PartnerStub>  rtrn = new ArrayList<>();
		for (Partner p : readAll) {
			rtrn.add(new PartnerStub(p, false));
			LOG.info("Partner stub added to list");
		}
		return rtrn;
	}

}
