package hu.musicorganizer.ejbservice.domain;

import java.util.Date;

public class AlbumStub {
	
	private String title;
	private Date releaseDate;
	private String genre;
	private String recordLabel;

	public AlbumStub(String title, Date releaseDate, String genre, String recordLabel) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.recordLabel = recordLabel;
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
