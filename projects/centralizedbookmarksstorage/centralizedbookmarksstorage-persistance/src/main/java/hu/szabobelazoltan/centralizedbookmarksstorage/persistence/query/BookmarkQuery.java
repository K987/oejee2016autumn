package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.query;

public class BookmarkQuery {
	public static final String USER_BY_NAME = "User.byName";
	public static final String SHARE_BY_DATE = "Share.byDate";
	public static final String SHARE_BY_BOOKMARK_ID = "Share.byBookmark";
	public static final String BOOKMARK_BY_ID = "Bookmark.byId";
	public static final String KEYWORD_BY_KW = "Keyword.byKeyword";
	public static final String CON_BOOKMARK_KEYWORD_BY_KW = "BookmarkKeywordConnection.byKeyword";
	public static final String CON_SHARE_KEYWORD_BY_KW = "BookmarkKeywordConnection.byKeyword";
}
