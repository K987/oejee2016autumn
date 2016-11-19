package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "horgaszto")
public class HorgasztoEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = 49619221020832690L;

	@Id
	@SequenceGenerator(name = " generatorHorgaszto", sequenceName = "horgaszto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHorgaszto")
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "vizterkod", nullable = false)
	private String vizterKod;

	@Column(name = "terulet", nullable = false)
	private int terulet;

	@Column(name = "to_tipusa")
	private String toTipus;

	@Column(name = "legnagyobbvizmelyseg")
	private int legnagyobbVizmelyseg;

	@Column(name = "tulajdonos", nullable = false)
	private String tulajdonos;

	@Column(name = "horgasztanya", nullable = false)
	private boolean horgasztanya;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVizterKod() {
		return vizterKod;
	}

	public void setVizterKod(String vizterKod) {
		this.vizterKod = vizterKod;
	}

	public int getTerulet() {
		return terulet;
	}

	public void setTerulet(int terulet) {
		this.terulet = terulet;
	}

	public String getToTipus() {
		return toTipus;
	}

	public void setToTipus(String toTipus) {
		this.toTipus = toTipus;
	}

	public int getLegnagyobbVizmelyseg() {
		return legnagyobbVizmelyseg;
	}

	public void setLegnagyobbVizmelyseg(int legnagyobbVizmelyseg) {
		this.legnagyobbVizmelyseg = legnagyobbVizmelyseg;
	}

	public String getTulajdonos() {
		return tulajdonos;
	}

	public void setTulajdonos(String tulajdonos) {
		this.tulajdonos = tulajdonos;
	}

	public boolean isHorgasztanya() {
		return horgasztanya;
	}

	public void setHorgasztanya(boolean horgasztanya) {
		this.horgasztanya = horgasztanya;
	}

}
