package hun.restoffice.persistence.entity.dailyTransaction;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the register_closes database table.
 * 
 */
@Embeddable
public class RegisterCloseId implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="register_close_register_id", unique=true, nullable=false, length=50)
	private String registerCloseRegisterId;

	@Column(name="register_close_no", unique=true, nullable=false)
	private Integer registerCloseNo;

	public RegisterCloseId() {
	}
	public String getRegisterCloseRegisterId() {
		return this.registerCloseRegisterId;
	}
	public void setRegisterCloseRegisterId(String registerCloseRegisterId) {
		this.registerCloseRegisterId = registerCloseRegisterId;
	}
	public Integer getRegisterCloseNo() {
		return this.registerCloseNo;
	}
	public void setRegisterCloseNo(Integer registerCloseNo) {
		this.registerCloseNo = registerCloseNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RegisterCloseId)) {
			return false;
		}
		RegisterCloseId castOther = (RegisterCloseId)other;
		return 
			this.registerCloseRegisterId.equals(castOther.registerCloseRegisterId)
			&& this.registerCloseNo.equals(castOther.registerCloseNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.registerCloseRegisterId.hashCode();
		hash = hash * prime + this.registerCloseNo.hashCode();
		
		return hash;
	}
}