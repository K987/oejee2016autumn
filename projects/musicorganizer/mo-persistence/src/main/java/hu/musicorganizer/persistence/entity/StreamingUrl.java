package hu.musicorganizer.persistence.entity;

import hu.musicorganizer.persistence.parameter.SongParameter;
import hu.musicorganizer.persistence.parameter.StreamingUrlParameter;
import hu.musicorganizer.persistence.query.SongQuery;
import hu.musicorganizer.persistence.query.StreamingUrlQuery;

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
@Table(name = "streamingurl")
@NamedQueries(value = { //
		@NamedQuery(name = StreamingUrlQuery.COUNT_BY_URL, query = "SELECT COUNT(s) FROM StreamingUrl s WHERE s.url=:" + StreamingUrlParameter.URL)
})
public class StreamingUrl {

	@Id
	@SequenceGenerator(name = "generatorStreamingurl", sequenceName = "streamingurl_streamingurl_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorStreamingurl")
	@Column(name = "streamingurl_id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "streamingurl_song_id", referencedColumnName = "song_id", nullable = false)
	private Song song;
	
	@Column(name = "streamingurl_type", nullable = false)
	private String type;
	
	@Column(name = "streamingurl_url", nullable = false)
	private String url;

	public StreamingUrl() {
		super();
	}
	
	public StreamingUrl(Song song, String type, String url) {
		super();
		this.song = song;
		this.type = type;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
