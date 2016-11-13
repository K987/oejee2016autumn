package hu.gyigorpeter.anglerregistry.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "horgaszto")
public class HorgasztoEntity implements Serializable {

	@Transient
	private static final long serialVersionUID = 49619221020832690L;

	@Id
	// @SequenceGenerator(name = " generatorHorgaszto", sequenceName = "horgaszto_horgaszto_id_seq", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorHorgaszto")
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

}
