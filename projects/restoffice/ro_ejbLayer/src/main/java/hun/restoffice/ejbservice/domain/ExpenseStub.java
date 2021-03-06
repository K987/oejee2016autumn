/**
 * 
 */
package hun.restoffice.ejbservice.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import hun.restoffice.remoteClient.domain.DocTypeStub;
import hun.restoffice.remoteClient.domain.PaymentMethodStub;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class ExpenseStub {

	private final String docId;
	private final DocTypeStub docType;
	private final PartnerStub issuer;
	private final PaymentMethodStub payMethod;
	private final BigDecimal grossTotal;
	private final String description;
	private final Calendar issue;
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
	public ExpenseStub(String docId, int docType, PartnerStub name, int payMethod, BigDecimal grossTotal, String description, Date registered, Date expiry,
			Date payed, Date startDate, Date endDate, String costCenter, String costType) {
		this.docId = docId;
		this.docType = DocTypeStub.values()[docType];
		this.issuer = name;
		this.payMethod = PaymentMethodStub.values()[payMethod];
		this.grossTotal = grossTotal;
		this.description = description;
		this.issue = toCalendar(registered);
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
	public DocTypeStub getDocType() {
		return docType;
	}

	/**
	 * @return the issuer
	 */
	public PartnerStub getIssuer() {
		return issuer;
	}

	/**
	 * @return the payMethod
	 */
	public PaymentMethodStub getPayMethod() {
		return payMethod;
	}

	/**
	 * @return the grossTotal
	 */
	public BigDecimal getGrossTotal() {
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
		return issue;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"ExpsnseStub [docId=%s, docType=%s, issuer=%s, payMethod=%s, grossTotal=%s, description=%s, registered=%s, expiry=%s, payed=%s, accPeriodStart=%s, accPeriodEnd=%s, costCenter=%s, costType=%s]",
				docId, docType, issuer == null ? "" : issuer.getName(), payMethod, grossTotal, description, issue.getTimeInMillis(), expiry == null ? "" : expiry.getTimeInMillis(), payed == null ? "" : payed.getTimeInMillis(), accPeriodStart == null ? "" : accPeriodStart.getTimeInMillis(), accPeriodEnd == null ? "" : accPeriodEnd.getTimeInMillis(), costCenter, costType);
	}
}
