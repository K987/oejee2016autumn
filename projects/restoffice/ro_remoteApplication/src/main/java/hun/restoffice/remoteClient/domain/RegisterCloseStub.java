/**
 *
 */
package hun.restoffice.remoteClient.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 *  DTO of RegisterClose
 *
 * @author kalmankostenszky
 */
public class RegisterCloseStub implements Serializable {

    private static final long serialVersionUID = 1L;


    private RegisterStub registerStub;
    private BigDecimal closeAmt;
    private Calendar closeDate;
    private int closeNo;
    private boolean closed;

    /**
     * @param regStub
     * @param registerCloseAmt
     * @param registerCloseDate
     * @param registerCloseNo
     */
    public RegisterCloseStub(final RegisterStub regStub, final BigDecimal registerCloseAmt,
            final Date registerCloseDate, final Integer registerCloseNo, final boolean closed) {
        registerStub = regStub;
        closeAmt = registerCloseAmt;
        if(registerCloseDate != null)
            (closeDate = Calendar.getInstance()).setTime(registerCloseDate);
        else
            closeDate = null;
        closeNo = registerCloseNo;
        this.closed = closed;
    }

    /**
     * @return the registerStub
     */
    public RegisterStub getRegisterStub() {
        return registerStub;
    }


    /**
     * @return the closeAmt
     */
    public BigDecimal getCloseAmt() {
        return closeAmt;
    }


    /**
     * @return the closeDate
     */
    public Calendar getCloseDate() {
        return closeDate;
    }


    /**
     * @return the closeNo
     */
    public int getCloseNo() {
        return closeNo;
    }


    /**
     * @param closeAmt
     *            the closeAmt to set
     */
    public void setCloseAmt(final BigDecimal closeAmt) {
        this.closeAmt = closeAmt;
    }

    /**
     * @param closeNo
     *            the closeNo to set
     */
    public void setCloseNo(final int closeNo) {
        this.closeNo = closeNo;
    }

    /**
     * @return the closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * @param closed
     *            the closed to set
     */
    public void setClosed(final boolean closed) {
        this.closed = closed;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RegisterCloseStub [registerStub=" + registerStub + ", closeAmt=" + closeAmt + ", closeDate="
                + String.format("%tc", closeDate) + ", closeNo=" + closeNo + ", closed=" + closed + "]";
    }


}
