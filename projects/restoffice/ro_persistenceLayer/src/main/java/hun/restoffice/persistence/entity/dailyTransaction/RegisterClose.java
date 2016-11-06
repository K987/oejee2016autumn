package hun.restoffice.persistence.entity.dailyTransaction;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the register_closes database table.
 * 
 */
@Entity
@Table(name="register_closes")
@NamedQuery(name="RegisterClos.findAll", query="SELECT r FROM RegisterClose r")
public class RegisterClose implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegisterCloseId id;

	@Column(name="register_close_amt", precision=131089)
	private BigDecimal registerCloseAmt;

	@Temporal(TemporalType.DATE)
	@Column(name="register_close_date", nullable=false)
	private Date registerCloseDate;

	//bi-directional many-to-one association to Register
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="register_close_register_id", referencedColumnName="register_id", nullable=false, insertable=false, updatable=false)
	private Register register;

	public RegisterClose() {
	}

	public RegisterCloseId getId() {
		return this.id;
	}

	public void setId(RegisterCloseId id) {
		this.id = id;
	}

	public BigDecimal getRegisterCloseAmt() {
		return this.registerCloseAmt;
	}

	public void setRegisterCloseAmt(BigDecimal registerCloseAmt) {
		this.registerCloseAmt = registerCloseAmt;
	}

	public Date getRegisterCloseDate() {
		return this.registerCloseDate;
	}

	public void setRegisterCloseDate(Date registerCloseDate) {
		this.registerCloseDate = registerCloseDate;
	}

	public Register getRegister() {
		return this.register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

}