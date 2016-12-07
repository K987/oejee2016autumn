/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.persistence.entity.financialTransaction.CostCenter;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface FinanceMiscConverterLocal {

	/**
	 * @param costCenters
	 * @return
	 */
	List<CostCenterStub> to(List<CostCenter> costCenters);

}
