package hu.musicorganizer.ejbservice.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerStub {

	private String nickname;
	private String emailAddress;
	private List<TracklistStub> tracklists;
	

	public CustomerStub(String nickname, String emailAddress) {
		super();
		this.nickname = nickname;
		this.emailAddress = emailAddress;
		this.tracklists = new ArrayList();
		
		//TODO: remove mocking
//		TrackListStub tls = new TrackListStub(this, "mylist");
//		tracklists.add(tls);
//		
//		StreamingUrlStub stus1 = new StreamingUrlStub(null, "", "youtube/1");
//		SongStub ss1 = new SongStub();
//		ss1.setTitle("random song1");
//		stus1.setSong(ss1);
//		
//		StreamingUrlStub stus2 = new StreamingUrlStub(null, "", "youtube/2");
//		SongStub ss2 = new SongStub();
//		ss2.setTitle("random song2");
//		stus2.setSong(ss2);
//		
//		tls.getStreamingUrls().add(stus1);
//		tls.getStreamingUrls().add(stus2);
//		
//		TrackListStub tls2 = new TrackListStub(this, "mylist2");
//		tracklists.add(tls2);
//		
//		StreamingUrlStub stus3 = new StreamingUrlStub(null, "", "youtube/3");
//		SongStub ss3 = new SongStub();
//		ss3.setTitle("random song3");
//		stus3.setSong(ss3);
//		
//		StreamingUrlStub stus4 = new StreamingUrlStub(null, "", "sc/1");
//		SongStub ss4 = new SongStub();
//		ss4.setTitle("random song4");
//		stus4.setSong(ss4);
//		
//		tls2.getStreamingUrls().add(stus3);
//		tls2.getStreamingUrls().add(stus4);
	}
	
	
	public List<TracklistStub> getTracklists() {
		return tracklists;
	}
	public void setTracklists(List<TracklistStub> tracklists) {
		this.tracklists = tracklists;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String username) {
		this.nickname = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
