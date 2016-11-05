/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;
import java.util.Vector;

import javax.ejb.Stateless;

import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.persistence.entity.partner.Partner;

/**
 * @author kalmankostenszky
 *
 */
@Stateless
public class PartnerConverter implements PartnerConverterLocal {

	@Override
	public PartnerStub to(Partner partner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartnerStub> toPartnerStubList(List<Partner> partners) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public PartnerStub to(Partner partner) {
		String account = partner.getPartnerBankAccount().toString();
		String technical = null;
		if (partner.getParnterTechnical())
			technical = "Y";
		else
			technical = "N";

		return new PartnerStub(partner.getPartnerName(), partner.getPartnerContact(), partner.getPartnerAddress(),
				account, technical);
	}

	@Override
	public List<PartnerStub> toPartnerStubList(List<Partner> partners) {
		List<PartnerStub> lst = new Vector<>();
		for (Partner partner : partners) {
			lst.add(to(partner));
		}
		return lst;
	}
	*/
}
