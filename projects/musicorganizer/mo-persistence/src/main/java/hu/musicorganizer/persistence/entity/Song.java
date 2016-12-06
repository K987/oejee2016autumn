package hu.musicorganizer.persistence.entity;

import hu.musicorganizer.persistence.parameter.CustomerParameter;
import hu.musicorganizer.persistence.parameter.SongParameter;
import hu.musicorganizer.persistence.query.SongQuery;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "song")
@NamedQueries(value = { //
		@NamedQuery(name = SongQuery.COUNT_BY_TITLE, query = "SELECT COUNT(s) FROM Song s WHERE s.title=:" + SongParameter.TITLE)
})
public class Song {
	
	@Id
	@SequenceGenerator(name = "generatorSong", sequenceName = "song_song_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorSong")
	@Column(name = "song_id", nullable = false)
	private Long id;
	
	@Column(name = "song_title", nullable = false)
	private String title;
	
	@Column(name = "song_category", nullable = true)
	private String category;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "song_artist_id", referencedColumnName = "artist_id", nullable = false)
	private Artist artist;

	public Song() {
		super();
	}
	
	public Song(String title, String category, Artist artist) {
		super();
		this.title = title;
		this.category = category;
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	
}
