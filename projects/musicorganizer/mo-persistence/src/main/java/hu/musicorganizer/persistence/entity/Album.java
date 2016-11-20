package hu.musicorganizer.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@SequenceGenerator(name = "generatorAlbum", sequenceName = "album_album_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAlbum")
	@Column(name = "album_id", nullable = false)
	private Long id;
	
	@Column(name = "album_title", nullable = false)
	private String title;
	
	@Column(name = "album_releasedate", nullable = false)
	private Date releaseDate;
	
	@Column(name = "album_genre", nullable = false)
	private String genre;
	
	@Column(name = "album_label", nullable = false)
	private String recordLabel;

	public Album(String title, Date releaseDate, String genre, String recordLabel) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.recordLabel = recordLabel;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	
	
}
