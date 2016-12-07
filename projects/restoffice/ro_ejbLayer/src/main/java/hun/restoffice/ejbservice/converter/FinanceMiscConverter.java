/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.persistence.entity.financialTransaction.CostCenter;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless
public class FinanceMiscConverter implements FinanceMiscConverterLocal {

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.FinanceMiscConverterLocal#to(java.util.List)
	 */
	@Override
	public List<CostCenterStub> to(List<CostCenter> costCenters) {

		List<CostCenterStub> rtrn = new ArrayList<>();
		for (CostCenter costCenter : costCenters) {
			rtrn.add(to(costCenter));
		}
		return rtrn;
	}

	/**
	 * @param costCenter
	 * @return
	 */
	private CostCenterStub to(CostCenter costCenter) {
		return new CostCenterStub(costCenter.getId(), costCenter.getName());
	}

}
