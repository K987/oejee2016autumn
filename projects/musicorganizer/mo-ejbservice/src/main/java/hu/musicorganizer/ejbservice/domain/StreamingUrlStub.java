package hu.musicorganizer.ejbservice.domain;

public class StreamingUrlStub {

	private SongStub song;
	private String type;
	private String url;

	public StreamingUrlStub(SongStub song, String type, String url) {
		super();
		this.song = song;
		this.type = type;
		this.url = url;
	}

	public SongStub getSong() {
		return song;
	}

	public void setSong(SongStub song) {
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
