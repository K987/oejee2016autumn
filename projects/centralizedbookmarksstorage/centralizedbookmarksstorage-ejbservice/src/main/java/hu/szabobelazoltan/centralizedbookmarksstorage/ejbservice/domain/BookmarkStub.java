package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain;

public class BookmarkStub {
	private final String title;
	private final String url;
	private final String description;
	private final String preview;

	public BookmarkStub(String title, String url, String description, String preview) {
		super();
		this.title = title;
		this.url = url;
		this.description = description;
		this.preview = preview;
	}

	public String getTitle() {
		return this.title;
	}

	public String getUrl() {
		return this.url;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPreview() {
		return this.preview;
	}

}
