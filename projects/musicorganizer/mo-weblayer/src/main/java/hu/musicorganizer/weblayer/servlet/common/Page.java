package hu.musicorganizer.weblayer.servlet.common;

public enum Page {

	LOGIN("login.jsp", "Login"),
	REGISTRATION("registration.jsp", "Login"),
	DASHBOARD("dashboard.jsp", "Dashboard"),
	TRACKLIST("tracklist.jsp", "Tracklist"),
	SETTINGS("settings.jsp", "Settings"),
	ERROR("error.jsp", "Error");

	private final String jspName;
	private final String url;

	public String getJspName() {
		return this.jspName;
	}

	public String getUrl() {
		return this.url;
	}
	
	public String getUrl(String errorMessage) {
		return this.url + "?errorMessage=" + errorMessage;
	}

	private Page(final String jspName, final String url) {
		this.jspName = jspName;
		this.url = url;
	}  
	
}
