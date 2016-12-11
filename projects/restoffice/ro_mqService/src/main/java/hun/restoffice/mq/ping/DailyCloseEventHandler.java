/**
 * 
 */
package hun.restoffice.mq.ping;

import java.io.Serializable;

import javax.enterprise.event.Observes;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.event.DailyCloseEvent;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class DailyCloseEventHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(DailyCloseEventHandler.class);
	
	public void handle(@Observes DailyCloseEvent e){
		LOG.info(e.toString());
	}

}
