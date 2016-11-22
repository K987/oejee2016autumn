/**
 * 
 */
package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class RegisterCloseStub implements Serializable {

	private final String id;
	private final RegisterType type;
	private BigDecimal amt;
	private Calendar date;
	private int closeNo;
	
	public RegisterCloseStub(BigDecimal closeAmt, Date closeDate, String id, int closeNo, RegisterType type){
		this.id = id;
		this.type = type;
		this.amt = closeAmt == null ? new BigDecimal(0) : closeAmt;
		this.closeNo = closeNo;
		if (closeDate != null)
			date = Calendar.getInstance();
			date.setTime(closeDate);
	}


	/**
	 * @return the amt
	 */
	public BigDecimal getAmt() {
		return amt;
	}

	/**
	 * @param amt the amt to set
	 */
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public RegisterType getType() {
		return type;
	}

	/**
	 * @return the closeNo
	 */
	public int getCloseNo() {
		return closeNo;
	}

	/**
	 * @param closeNo the closeNo to set
	 */
	public void setCloseNo(int closeNo) {
		this.closeNo = closeNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("RegisterCloseStub [id=%s, type=%s, amt=%s, date=%s]", id, type, amt, date);
	}
	
	
	
}
