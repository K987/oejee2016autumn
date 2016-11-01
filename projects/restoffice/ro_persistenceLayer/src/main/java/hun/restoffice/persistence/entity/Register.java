package hun.restoffice.persistence.entity;

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

	@Column(name="register_type", nullable=false)
	private Integer registerType;

	//bi-directional many-to-one association to RegisterClos
	@OneToMany(mappedBy="register")
	private Set<RegisterClos> registerCloses;

	public Register() {
	}

	public String getRegisterId() {
		return this.registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public Integer getRegisterType() {
		return this.registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public Set<RegisterClos> getRegisterCloses() {
		return this.registerCloses;
	}

	public void setRegisterCloses(Set<RegisterClos> registerCloses) {
		this.registerCloses = registerCloses;
	}

	public RegisterClos addRegisterClos(RegisterClos registerClos) {
		getRegisterCloses().add(registerClos);
		registerClos.setRegister(this);

		return registerClos;
	}

	public RegisterClos removeRegisterClos(RegisterClos registerClos) {
		getRegisterCloses().remove(registerClos);
		registerClos.setRegister(null);

		return registerClos;
	}

}