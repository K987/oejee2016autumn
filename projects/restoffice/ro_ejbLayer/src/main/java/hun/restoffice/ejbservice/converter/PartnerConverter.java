/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;
import java.util.Vector;

import javax.ejb.Stateless;

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
	public List<PartnerStub> toPartnerStubList(List<Partner> partners) {
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

}
