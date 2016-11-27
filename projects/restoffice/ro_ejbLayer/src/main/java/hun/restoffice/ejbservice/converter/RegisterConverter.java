/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.persistence.entity.dailyTransaction.RegisterClose;
import hun.restoffice.remoteClient.domain.RegisterStub;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless
public class RegisterConverter implements RegisterConverterLocal {

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.ejbservice.converter.RegisterConverterLocal#to(java.util.List)
	 */
	@Override
	public List<RegisterStub> to(List<RegisterClose> registers) {
		List<RegisterStub> rtrn = new ArrayList<>();
		for (RegisterClose registerClose : registers) {
			rtrn.add(to(registerClose));
		}
		return rtrn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hun.restoffice.ejbservice.converter.RegisterConverterLocal#to(hun.restoffice.remoteClient.domain.RegisterStub)
	 */
	@Override
	public RegisterStub to(RegisterClose register) {
		RegisterStub rtrn = new RegisterStub(register.getRegisterCloseAmt(), register.getRegisterCloseDate(), register.getRegister().getRegisterId(),
				register.getId().getRegisterCloseNo(), register.getRegister().getRegisterType().ordinal());
		return rtrn;
	}



}
