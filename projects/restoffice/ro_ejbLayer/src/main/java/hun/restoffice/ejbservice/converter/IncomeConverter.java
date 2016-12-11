/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import javax.ejb.Stateless;

import hun.restoffice.persistence.entity.financialTransaction.DocumentType;
import hun.restoffice.persistence.entity.financialTransaction.Income;
import hun.restoffice.persistence.entity.financialTransaction.PaymentMethod;
import hun.restoffice.remoteClient.domain.IncomeStub;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/incomeConverter")
public class IncomeConverter implements IncomeConverterLocal {

	/* (non-Javadoc)
	 * @see hun.restoffice.ejbservice.converter.IncomeConverterLocal#from(hun.restoffice.remoteClient.domain.IncomeStub)
	 */
	@Override
	public Income from(IncomeStub stub) {
		
		return new Income(
				stub.getDocId(),
				stub.getDescription(),
				DocumentType.values()[stub.getDocType().ordinal()],
				stub.getGrossTotal(),
				stub.getRegistered(),
				stub.getExpiry(),
				stub.getPayed(),
				stub.getAccPeriodStart(),
				stub.getAccPeriodEnd(),
				stub.getIncomeType(),
				PaymentMethod.values()[stub.getPayMethod().ordinal()],
				stub.getPartner()		
				);
		
	}

}
