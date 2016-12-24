package hu.musicorganizer.persistence.entity;

import hu.musicorganizer.persistence.parameter.ArtistParameter;
import hu.musicorganizer.persistence.parameter.CustomerParameter;
import hu.musicorganizer.persistence.query.ArtistQuery;
import hu.musicorganizer.persistence.query.CustomerQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
@NamedQueries(value = { //
		@NamedQuery(name = ArtistQuery.COUNT_BY_NAME, query = "SELECT COUNT(a) FROM Artist a WHERE a.name=:" + ArtistParameter.NAME),
		@NamedQuery(name = ArtistQuery.GET_BY_NAME, query = "SELECT a FROM Artist a WHERE a.name=:" + ArtistParameter.NAME)
})
public class Artist {

	@Id
	@SequenceGenerator(name = "generatorArtist", sequenceName = "artist_artist_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorArtist")
	@Column(name = "artist_id", nullable = false)
	private Long id;
	
	@Column(name = "artist_name", nullable = false)
	private String name;

	public Artist() {
		super();
	}
	
	public Artist(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
