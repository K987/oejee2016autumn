package hu.musicorganizer.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "artist")
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
