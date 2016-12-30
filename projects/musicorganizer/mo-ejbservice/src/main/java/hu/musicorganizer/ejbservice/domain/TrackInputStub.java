package hu.musicorganizer.ejbservice.domain;

public class TrackInputStub {

	private String tracklistName;
	private String customerEmailAddress;
	private String artistName;
	private String streamingUrl;
	private String songTitle;
	private String songCategory;
	
	
	public TrackInputStub() {
		super();
	}
	
	public TrackInputStub(String tracklistName, String customerEmailAddress,
			String artistName, String streamingUrl, String songTitle,
			String songCategory) {
		super();
		this.tracklistName = tracklistName;
		this.customerEmailAddress = customerEmailAddress;
		this.artistName = artistName;
		this.streamingUrl = streamingUrl;
		this.songTitle = songTitle;
		this.songCategory = songCategory;
	}
	
	public String getTracklistName() {
		return tracklistName;
	}
	public void setTracklistName(String tracklistName) {
		this.tracklistName = tracklistName;
	}
	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}
	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getStreamingUrl() {
		return streamingUrl;
	}
	public void setStreamingUrl(String streamingUrl) {
		this.streamingUrl = streamingUrl;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getSongCategory() {
		return songCategory;
	}
	public void setSongCategory(String songCategory) {
		this.songCategory = songCategory;
	}
	
	
	
}
