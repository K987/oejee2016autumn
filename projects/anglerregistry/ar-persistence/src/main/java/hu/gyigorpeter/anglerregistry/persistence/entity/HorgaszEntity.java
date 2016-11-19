package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "horgasz")
@NamedQueries(value = { @NamedQuery(name = "HorgaszEntity.GET_BY_ID", query = "SELECT horgasz FROM HorgaszEntity horgasz WHERE horgasz.id=:id"),
		@NamedQuery(name = "HorgaszEntity.GET_ALL", query = "SELECT horgasz FROM HorgaszEntity horgasz ORDER BY horgasz.nev") })
public class HorgaszEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = -4705781742838571940L;

	@Id
	@SequenceGenerator(name = " generatorHorgasz", sequenceName = "horgasz_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHorgasz")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "nev", nullable = false)
	private String nev;

	@Column(name = "anyjaneve", nullable = false)
	private String anyjaNeve;

	@Column(name = "szuletesiido", nullable = false)
	private Date szuletesiIdo;

	@Column(name = "szuletesihely", nullable = false)
	private String szuletesiHely;

	@Column(name = "irsz")
	private int irsz;

	@Column(name = "varos")
	private String varos;

	@Column(name = "cim")
	private String cim;

	@Column(name = "tarsadalmimunka")
	private int tarsadalmiMunka;

	@Column(name = "eltiltas")
	@Temporal(TemporalType.DATE)
	private Date eltiltas;

	@Column(name = "tage", nullable = false)
	private boolean tagE;

	@Column(name = "titkarsagitage", nullable = false)
	private boolean titkarsagiTagE;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getAnyjaNeve() {
		return anyjaNeve;
	}

	public void setAnyjaNeve(String anyjaNeve) {
		this.anyjaNeve = anyjaNeve;
	}

	public Date getSzuletesiIdo() {
		return szuletesiIdo;
	}

	public void setSzuletesiIdo(Date szuletesiIdo) {
		this.szuletesiIdo = szuletesiIdo;
	}

	public String getSzuletesiHely() {
		return szuletesiHely;
	}

	public void setSzuletesiHely(String szuletesiHely) {
		this.szuletesiHely = szuletesiHely;
	}

	public int getIrsz() {
		return irsz;
	}

	public void setIrsz(int irsz) {
		this.irsz = irsz;
	}

	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public int getTarsadalmiMunka() {
		return tarsadalmiMunka;
	}

	public void setTarsadalmiMunka(int tarsadalmiMunka) {
		this.tarsadalmiMunka = tarsadalmiMunka;
	}

	public Date getEltiltas() {
		return eltiltas;
	}

	public void setEltiltas(Date eltiltas) {
		this.eltiltas = eltiltas;
	}

	public boolean isTagE() {
		return tagE;
	}

	public void setTagE(boolean tagE) {
		this.tagE = tagE;
	}

	public boolean isTitkarsagiTagE() {
		return titkarsagiTagE;
	}

	public void setTitkarsagiTagE(boolean titkarsagiTagE) {
		this.titkarsagiTagE = titkarsagiTagE;
	}

}
