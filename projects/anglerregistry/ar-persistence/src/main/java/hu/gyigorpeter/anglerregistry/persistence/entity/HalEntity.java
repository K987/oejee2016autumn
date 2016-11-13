package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "hal")
public class HalEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -2650585615626806254L;

	@Id
	// @SequenceGenerator(name = " generatorHal", sequenceName = "hal_hal_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHal")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "halnev", nullable = false)
	private String halNev;

	@Column(name = "minimummeret")
	private int minimumMeret;

	@Column(name = "napidarabszam", nullable = false)
	private int napiDarabSzam;

	@Column(name = "tilalmiidoszakkezdete")
	@Temporal(TemporalType.DATE)
	private Date tilalmiIdoszakKezdete;

	@Temporal(TemporalType.DATE)
	@Column(name = "tilalmiidoszakvege")
	private Date tilalmiIdoszakVege;

	@Column(name = "pusztulas")
	private int pusztulas;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHalNev() {
		return this.halNev;
	}

	public void setHalNev(String halNev) {
		this.halNev = halNev;
	}

	public int getMinimumMeret() {
		return this.minimumMeret;
	}

	public void setMinimumMeret(int minimumMeret) {
		this.minimumMeret = minimumMeret;
	}

	public int getNapiDarabSzam() {
		return this.napiDarabSzam;
	}

	public void setNapiDarabSzam(int napiDarabSzam) {
		this.napiDarabSzam = napiDarabSzam;
	}

	public Date getTilalmiIdoszakKezdete() {
		return this.tilalmiIdoszakKezdete;
	}

	public void setTilalmiIdoszakKezdete(Date tilalmiIdoszakKezdete) {
		this.tilalmiIdoszakKezdete = tilalmiIdoszakKezdete;
	}

	public Date getTilalmiIdoszakVege() {
		return this.tilalmiIdoszakVege;
	}

	public void setTilalmiIdoszakVege(Date tilalmiIdoszakVege) {
		this.tilalmiIdoszakVege = tilalmiIdoszakVege;
	}

	public int getPusztulas() {
		return this.pusztulas;
	}

	public void setPusztulas(int pusztulas) {
		this.pusztulas = pusztulas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
