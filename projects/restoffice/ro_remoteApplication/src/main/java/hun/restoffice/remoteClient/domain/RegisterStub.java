/**
 * 
 */
package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *  DTO of Register
 *
 * @author kalmankostenszky
 */
public class RegisterStub implements Serializable {

	private final String id;
	private final int type;
	private double amt;
	private Calendar date;
	private int closeNo;
	

	public RegisterStub(BigDecimal closeAmt, Date closeDate, String id, Integer closeNo, int type){
		this.id = id;
		this.type = type;
		this.amt = closeAmt.doubleValue();
		this.closeNo = closeNo;
		if (closeDate != null)
			date = Calendar.getInstance();
			date.setTime(closeDate);
	}

	/**
	 * @return the amt
	 */
	public double getAmt() {
		return amt;
	}

	/**
	 * @param amt the amt to set
	 */
	public void setAmt(double amt) {
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
	public int getType() {
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
