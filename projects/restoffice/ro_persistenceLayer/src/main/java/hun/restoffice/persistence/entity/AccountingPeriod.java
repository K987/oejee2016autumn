package hun.restoffice.persistence.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Calss for accounting period in expense and income entites
 *
 */
@Embeddable
public class AccountingPeriod {

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Transient
	private Integer periodLength;

	public AccountingPeriod() {

	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		setMonths();
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		setMonths();
	}

	/**
	 * @return the monthsBetween
	 */
	public int getPeriodLength() {
		if (periodLength == null) {
			setMonths();
		}
		return periodLength;
	}

	private void setMonths() {
		this.periodLength = 1;
		if (this.startDate != null && this.endDate != null && this.endDate.getTime() >= this.startDate.getTime()) {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(startDate);
			end.setTime(endDate);
			int years = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
			int months = years * 12 + end.get(Calendar.MONTH) - end.get(Calendar.MONTH);
			this.periodLength += months;
		}
	}
}
