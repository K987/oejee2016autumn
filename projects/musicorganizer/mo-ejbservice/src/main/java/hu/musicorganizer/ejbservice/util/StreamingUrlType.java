package hu.musicorganizer.ejbservice.util;

import java.util.HashMap;
import java.util.Map.Entry;

public class StreamingUrlType {
	
	public static final String YOUTUBE = "YOUTUBE";
	public static final String SOUNDCLOUD = "SOUNDCLOUD";
	public static final String SPOTIFY = "SPOTIFY";
	public static final String MIXCLOUD = "MIXCLOUD";
	public static final String GOOGLE_PLAY_MUSIC = "GOOGLE_PLAY_MUSIC";
	public static final String DEEZER = "DEEZER";
	public static final String UNKNOWN = "UNKNOWN";
	
	public static final HashMap<String, String> TYPE_URLPATTERN_PAIRS = new HashMap<String, String>();
	static
	{
		TYPE_URLPATTERN_PAIRS.put(YOUTUBE, "youtube.com");
		TYPE_URLPATTERN_PAIRS.put(SOUNDCLOUD, "soundcloud.com");
		TYPE_URLPATTERN_PAIRS.put(SPOTIFY, "spotify.com");
		TYPE_URLPATTERN_PAIRS.put(MIXCLOUD, "mixcloud.com");
		TYPE_URLPATTERN_PAIRS.put(GOOGLE_PLAY_MUSIC, "play.google.com/store/music");
		TYPE_URLPATTERN_PAIRS.put(DEEZER, "deezer.com");
	}
	
	public static String of(String streamingUrl) {
		String type = UNKNOWN;
		
		for (Entry<String, String> urlPattern : TYPE_URLPATTERN_PAIRS.entrySet()) {
			if (streamingUrl.toLowerCase().contains(urlPattern.getValue().toLowerCase())) {
				return urlPattern.getKey();
			}
		}
		
		return type;
		
	}
	
}
