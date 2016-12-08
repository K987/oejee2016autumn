package hu.musicorganizer.ejbservice.domain;

public class SongStub {
	
	private String title;
	private String category;
	private ArtistStub artist;
	
	
	public SongStub(String title, String category, ArtistStub artist) {
		this.title = title;
		this.category = category;
		this.artist = artist;
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
	public ArtistStub getArtist() {
		return artist;
	}
	public void setArtist(ArtistStub artist) {
		this.artist = artist;
	}
		
}
