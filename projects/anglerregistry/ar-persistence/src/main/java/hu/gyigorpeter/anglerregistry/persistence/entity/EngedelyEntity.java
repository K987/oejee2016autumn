package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "engedely")
public class EngedelyEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -5767572163046328854L;

	@Id
	@SequenceGenerator(name = " generatorEngedely", sequenceName = "engedely_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorEngedely")
	@Column(name = "id")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "horgaszid", referencedColumnName = "id", nullable = false)
	private HorgaszEntity horgaszEntity;

	@Column(name = "allamijegyid")
	private String allamiJegyId;

	@Column(name = "engedely_tipusa")
	private String engedelyTipusa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HorgaszEntity getHorgasz() {
		return horgaszEntity;
	}

	public void setHorgasz(HorgaszEntity horgasz) {
		horgaszEntity = horgasz;
	}

	public String getAllamiJegyId() {
		return allamiJegyId;
	}

	public void setAllamiJegyId(String allamiJegyId) {
		this.allamiJegyId = allamiJegyId;
	}

	public String getEngedelyTipusa() {
		return engedelyTipusa;
	}

	public void setEngedelyTipusa(String engedelyTipusa) {
		this.engedelyTipusa = engedelyTipusa;
	}

}
