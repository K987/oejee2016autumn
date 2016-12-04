package hu.musicorganizer.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "song")
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

	public Song() {
		super();
	}
	
	public Song(String title, String category) {
		super();
		this.title = title;
		this.category = category;
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

	
}
