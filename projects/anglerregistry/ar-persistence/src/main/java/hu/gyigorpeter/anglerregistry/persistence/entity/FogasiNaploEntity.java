package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fogasinaplo")
public class FogasiNaploEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -3406588429003984346L;

	@Id
	@SequenceGenerator(name = " generatorFogasiNaplo", sequenceName = "fogasinaplo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorFogasiNaplo")
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "engedelyid", referencedColumnName = "id", nullable = false)
	private EngedelyEntity engedelyEntity;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = HorgasztoEntity.class)
	@JoinColumn(name = "toid", referencedColumnName = "id", nullable = false)
	private Set<HorgasztoEntity> horgaszToEntity;

	@Column(name = "idopont")
	private Timestamp idopont;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = HalEntity.class)
	@JoinColumn(name = "halid", referencedColumnName = "id", nullable = false)
	private HalEntity halEntity;

	@Column(name = "mennyiseg")
	private int mennyiseg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EngedelyEntity getEngedelyEntity() {
		return engedelyEntity;
	}

	public void setEngedelyEntity(EngedelyEntity engedelyEntity) {
		this.engedelyEntity = engedelyEntity;
	}

	public Timestamp getIdopont() {
		return idopont;
	}

	public void setIdopont(Timestamp idopont) {
		this.idopont = idopont;
	}

	public HalEntity getHalEntity() {
		return halEntity;
	}

	public void setHalEntity(HalEntity halEntity) {
		this.halEntity = halEntity;
	}

	public int getMennyiseg() {
		return mennyiseg;
	}

	public void setMennyiseg(int mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	public Set<HorgasztoEntity> getHorgaszToEntity() {
		return horgaszToEntity;
	}

	public void setHorgaszToEntity(Set<HorgasztoEntity> horgaszToEntity) {
		this.horgaszToEntity = horgaszToEntity;
	}

}
