package hu.gyigorpeter.anglerregistry.ejbservice.pojo;

import java.util.Date;

public class Horgasz {

	private String nev;
	private String anyjaNeve;
	private Date szuletesiIdo;
	private String szuletesiHely;
	private int irsz;
	private String varos;
	private String cim;
	private int tarsadalmiMunka;
	private Date eliltas;
	private boolean tagE;
	private boolean titkarsagiTagE;

	public String getNev() {
		return this.nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getAnyjaNeve() {
		return this.anyjaNeve;
	}

	public void setAnyjaNeve(String anyjaNeve) {
		this.anyjaNeve = anyjaNeve;
	}

	public Date getSzuletesiIdo() {
		return this.szuletesiIdo;
	}

	public void setSzuletesiIdo(Date szuletesiIdo) {
		this.szuletesiIdo = szuletesiIdo;
	}

	public String getSzuletesiHely() {
		return this.szuletesiHely;
	}

	public void setSzuletesiHely(String szuletesiHely) {
		this.szuletesiHely = szuletesiHely;
	}

	public int getIrsz() {
		return this.irsz;
	}

	public void setIrsz(int irsz) {
		this.irsz = irsz;
	}

	public String getVaros() {
		return this.varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	public String getCim() {
		return this.cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public int getTarsadalmiMunka() {
		return this.tarsadalmiMunka;
	}

	public void setTarsadalmiMunka(int tarsadalmiMunka) {
		this.tarsadalmiMunka = tarsadalmiMunka;
	}

	public Date getEliltas() {
		return this.eliltas;
	}

	public void setEliltas(Date eliltas) {
		this.eliltas = eliltas;
	}

	public boolean isTagE() {
		return this.tagE;
	}

	public void setTagE(boolean tagE) {
		this.tagE = tagE;
	}

	public boolean isTitkarsagiTagE() {
		return this.titkarsagiTagE;
	}

	public void setTitkarsagiTagE(boolean titkarsagiTagE) {
		this.titkarsagiTagE = titkarsagiTagE;
	}

	public Horgasz(String nev, String anyjaNeve, Date szuletesiIdo, String szuletesiHely, int irsz, String varos, String cim, int tarsadalmiMunka, Date eliltas,
			boolean tagE, boolean titkarsagiTagE) {
		this.nev = nev;
		this.anyjaNeve = anyjaNeve;
		this.szuletesiIdo = szuletesiIdo;
		this.szuletesiHely = szuletesiHely;
		this.irsz = irsz;
		this.varos = varos;
		this.cim = cim;
		this.tarsadalmiMunka = tarsadalmiMunka;
		this.eliltas = eliltas;
		this.tagE = tagE;
		this.titkarsagiTagE = titkarsagiTagE;
	}

}
