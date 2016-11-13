/**
 * 
 */
package hu.restoffice.restService.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

/**
 * String to Calendar converter type
 *
 * @author kalmankostenszky
 */
public class RESTDate  {

	private static final Logger LOG = Logger.getLogger(RESTDate.class);
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private Calendar date;

	public RESTDate(String date) throws WebApplicationException {
		if (date == null || date.equalsIgnoreCase("")) {
			this.date = null;
		} else {
			try {
				this.date = Calendar.getInstance();
				this.date.setTime((df.parse(date)));
			} catch (Exception e) {
				LOG.error(e.getMessage());
				
				throw new WebApplicationException("valid format is yyyy-MM-dd",e,Response.status(Status.BAD_REQUEST).entity("valid date format is: yyyy-MM-dd").build());
			}
		}
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}
}
