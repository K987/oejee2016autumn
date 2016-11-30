package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.parameter.BookmarkParameter;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.query.BookmarkQuery;

@Entity
@Table(name = "cbms_bookmark")
@NamedQueries(value = {
		@NamedQuery(name = BookmarkQuery.BOOKMARK_BY_ID, query = "SELECT b FROM cbms_bookmark bt WHERE b.bookmark_id=:" + BookmarkParameter.BOOKMARK_ID),
		@NamedQuery(name = BookmarkQuery.BOOKMARK_BY_USER, query = "SELECT b FROM cbms_bookmark bt WHERE b.bookmark_owner=:"
				+ BookmarkParameter.BOOKMARK_USERID),
		@NamedQuery(name = BookmarkQuery.BOOKMARK_BY_KEYWORD, query = "SELECT b FROM cbms_bookmark bt, (Select cbms_bm_kw_connecton.bookmark bm FROM cbms_bm_kw_connection RIGHT JOIN cbms_keyword ON cbms_bm_kw_connection.keyword = cbms_keyword.keywor_id WHERE cbms_keyword.keyword=:'"
				+ BookmarkParameter.KEYWORD + "') AS KWFIND WHERE cbms_bookmark.bookmark_id = KWFIND.bm") })
public class Bookmark implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 9132982902598887235L;

	@Id
	@SequenceGenerator(name = "generatorBook", sequenceName = "cbms_bookmark_bookmark_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "bookmark_id", nullable = false)
	private Long id;

	@Column(name = "bookmark_title", nullable = false)
	private String title;

	@Column(name = "bookmark_url", nullable = false)
	private String url;

	@Column(name = "bookmark_description", nullable = false)
	private String description;

	@Column(name = "bookmark_preview", nullable = false)
	private String preview;

	@Column(name = "bookmark_owner", nullable = false)
	private Long owner;

	public Bookmark() {
		this(null, null, null, null, 0l);
	}

	public Bookmark(String title, String url, String description, String preview, long owner) {
		super();
		this.title = title;
		this.url = url;
		this.description = description;
		this.preview = preview;
		this.owner = owner;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreview() {
		return this.preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public Long getOwner() {
		return this.owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

}
