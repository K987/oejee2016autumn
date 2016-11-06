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

	List<PartnerStub> to(List<Partner> partners);

	/**
	 * Convert contact info of partner
	 * @param partner
	 * @return 
	 */
	PartnerContactStub toContact(Partner partner);

	/**
	 * Convert contact info of a list of partners
	 * @param readAll
	 * @return
	 */
	List<PartnerStub> toContact(List<Partner> readAll);
}
