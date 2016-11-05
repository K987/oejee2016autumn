package hun.restoffice.persistence.entity.dailyTransaction;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the registers database table.
 * 
 */
@Entity
@Table(name="registers")
@NamedQuery(name="Register.findAll", query="SELECT r FROM Register r")
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="register_id", unique=true, nullable=false, length=50)
	private String registerId;

	@Enumerated(value=EnumType.ORDINAL)
	@Column(name="register_type", nullable=false)
	private RegisterType registerType;

	//bi-directional many-to-one association to RegisterClos
	@OneToMany(mappedBy="register", targetEntity=RegisterClose.class)
	private Set<RegisterClose> registerCloses;

	public Register() {
	}

	public String getRegisterId() {
		return this.registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public RegisterType getRegisterType() {
		return this.registerType;
	}

	public void setRegisterType(RegisterType registerType) {
		this.registerType = registerType;
	}

	public Set<RegisterClose> getRegisterCloses() {
		return this.registerCloses;
	}

	public void setRegisterCloses(Set<RegisterClose> registerCloses) {
		this.registerCloses = registerCloses;
	}

	public RegisterClose addRegisterClose(RegisterClose registerClos) {
		getRegisterCloses().add(registerClos);
		registerClos.setRegister(this);

		return registerClos;
	}

	public RegisterClose removeRegisterClose(RegisterClose registerClos) {
		getRegisterCloses().remove(registerClos);
		registerClos.setRegister(null);

		return registerClos;
	}

}