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

	/**
	 * Convert contact info of partner
	 * @param partner
	 * @return 
	 */
	PartnerContactStub toContact(Partner partner);

	/**
	 * Convert contact info of a list of partners
	 * @param partners
	 * @return
	 */
	List<PartnerStub> toContact(List<Partner> partners);

	/**
	 * Convert partner of a list of partners
	 * @param partners
	 * @return
	 */
	List<PartnerStub> toPartner(List<Partner> partners);
}
