/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.persistence.entity.partner.Partner;

/**
 * @author kalmankostenszky
 *
 */
@Local
public interface PartnerConverterLocal {

	PartnerStub to(Partner partner);

	List<PartnerStub> toPartnerStubList(List<Partner> partners);

	/**
	 * Convert contact info of partner
	 * @param partner
	 * @return 
	 */
	PartnerContactStub toContact(Partner partner);
}
