/**
 * 
 */
package hun.restoffice.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.persistence.entity.dailyTransaction.RegisterClose;
import hun.restoffice.remoteClient.domain.RegisterStub;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Local
public interface RegisterConverterLocal {

	/**
	 * @param registers
	 * @return
	 */
	List<RegisterStub> to(List<RegisterClose> registers);

	/**
	 * 
	 * @param register
	 * @return
	 */
	RegisterStub to(RegisterClose register);
}
