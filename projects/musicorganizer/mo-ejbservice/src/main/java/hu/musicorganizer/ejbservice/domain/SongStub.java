package hu.musicorganizer.ejbservice.domain;

public class SongStub {
	
	private String title;
	private String category;
	
	
	public SongStub(String title, String category) {
		this.title = title;
		this.category = category;
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
