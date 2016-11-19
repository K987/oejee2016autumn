package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "telepites")
public class TelepitesEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -1225740194904957262L;

	@Id
	@SequenceGenerator(name = " generatorTelepites", sequenceName = "telepites_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTelepites")
	@Column(name = "id", nullable = false)
	private long id;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = HorgasztoEntity.class)
	@JoinColumn(name = "toid", referencedColumnName = "id", nullable = false)
	private Set<HorgasztoEntity> horgaszToEntity;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = HalEntity.class)
	@JoinColumn(name = "halid", referencedColumnName = "id", nullable = false)
	private Set<HalEntity> halEntity;

	@Column(name = "datum")
	private Date datum;

	@Column(name = "kor")
	private int kor;

	@Column(name = "mennyiseg")
	private int mennyiseg;

	@Column(name = "tilalminapokszama")
	private int tilalmiNapokSzama;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMennyiseg() {
		return mennyiseg;
	}

	public void setMennyiseg(int mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	public int getTilalmiNapokSzama() {
		return tilalmiNapokSzama;
	}

	public void setTilalmiNapokSzama(int tilalmiNapokSzama) {
		this.tilalmiNapokSzama = tilalmiNapokSzama;
	}

	public Set<HorgasztoEntity> getHorgaszToEntity() {
		return horgaszToEntity;
	}

	public void setHorgaszToEntity(Set<HorgasztoEntity> horgaszToEntity) {
		this.horgaszToEntity = horgaszToEntity;
	}

	public Set<HalEntity> getHalEntity() {
		return halEntity;
	}

	public void setHalEntity(Set<HalEntity> halEntity) {
		this.halEntity = halEntity;
	}

}
