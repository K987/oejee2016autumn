/**
 * 
 */
package hun.restoffice.ejbservice.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import hun.restoffice.persistence.entity.financialTransaction.DocumentType;
import hun.restoffice.persistence.entity.financialTransaction.PaymentMethod;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class ExpenseStub {

	private final String docId;
	private final DocumentType docType;
	private final String issuer;
	private final PaymentMethod payMethod;
	private final double grossTotal;
	private final String description;
	private final Calendar registered;
	private final Calendar expiry;
	private final Calendar payed;
	private final Calendar accPeriodStart;
	private final Calendar accPeriodEnd;
	private final String costCenter;
	private final String costType;

	/**
	 * @param docId
	 * @param docType
	 * @param name
	 * @param payMethod
	 * @param payMethod2
	 * @param grossTotal
	 * @param description
	 * @param registered
	 * @param expiry
	 * @param payed
	 * @param startDate
	 * @param endDate
	 * @param costCenter
	 * @param costType
	 */
	public ExpenseStub(String docId, DocumentType docType, String name, PaymentMethod payMethod, BigDecimal grossTotal,
			String description, Date registered, Date expiry, Date payed, Date startDate, Date endDate, String costCenter, String costType) {
		this.docId = docId;
		this.docType = docType;
		this.issuer = name;
		this.payMethod = payMethod;
		this.grossTotal = grossTotal.doubleValue();
		this.description = description;
		this.registered = toCalendar(registered);
		this.expiry = toCalendar(expiry);
		this.payed = toCalendar(payed);
		this.accPeriodStart = toCalendar(startDate);
		this.accPeriodEnd = toCalendar(endDate);
		this.costCenter = costCenter;
		this.costType = costType;
	}

	/**
	 * @param date
	 * @return
	 */
	private Calendar toCalendar(Date date) {
		if (date == null)
			return null;
		Calendar rtrn = Calendar.getInstance();
		rtrn.setTime(date);
		return rtrn;
	}

	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}

	/**
	 * @return the docType
	 */
	public DocumentType getDocType() {
		return docType;
	}

	/**
	 * @return the issuer
	 */
	public String getIssuer() {
		return issuer;
	}

	/**
	 * @return the payMethod
	 */
	public PaymentMethod getPayMethod() {
		return payMethod;
	}

	/**
	 * @return the grossTotal
	 */
	public double getGrossTotal() {
		return grossTotal;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the registered
	 */
	public Calendar getRegistered() {
		return registered;
	}

	/**
	 * @return the expiry
	 */
	public Calendar getExpiry() {
		return expiry;
	}

	/**
	 * @return the payed
	 */
	public Calendar getPayed() {
		return payed;
	}

	/**
	 * @return the accPeriodStart
	 */
	public Calendar getAccPeriodStart() {
		return accPeriodStart;
	}

	/**
	 * @return the accPeriodEnd
	 */
	public Calendar getAccPeriodEnd() {
		return accPeriodEnd;
	}

	/**
	 * @return the costCenter
	 */
	public String getCostCenter() {
		return costCenter;
	}

	/**
	 * @return the costType
	 */
	public String getCostType() {
		return costType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"ExpsnseStub [docId=%s, docType=%s, issuer=%s, payMethod=%s, grossTotal=%s, description=%s, registered=%s, expiry=%s, payed=%s, accPeriodStart=%s, accPeriodEnd=%s, costCenter=%s, costType=%s]",
				docId, docType, issuer, payMethod, grossTotal, description, registered, expiry, payed, accPeriodStart, accPeriodEnd, costCenter, costType);
	}
}
