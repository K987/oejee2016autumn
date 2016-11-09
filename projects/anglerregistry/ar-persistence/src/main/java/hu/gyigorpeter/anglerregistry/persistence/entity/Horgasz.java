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
@Table(name = "horgasz")
public class Horgasz implements Serializable {

	@Transient
	private static final long serialVersionUID = -4705781742838571940L;

	@Id
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
	
	
	
	
	
	
	
	
	
	
	
	
}
