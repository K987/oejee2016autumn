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
@Table(name = "cbms_bm_kw_connection")
@NamedQueries(value = { @NamedQuery(name = BookmarkQuery.CON_BOOKMARK_KEYWORD_BY_KW, query = "SELECT c FROM cbms_bm_kw_connection c WHERE c.Keyword=:"
		+ BookmarkParameter.KEYWORD_ID) })
public class BookmarkKeywordConnection implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4937752490419776777L;

	@Id
	@SequenceGenerator(name = "generatorBook", sequenceName = "cbms_bm_kw_connection_connection_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "connection_id", nullable = false)
	private Long id;

	@Column(name = "bookmark", nullable = false)
	private Long bookmark;

	@Column(name = "keyword", nullable = false)
	private Long keyword;

	public BookmarkKeywordConnection(Long id, Long bookmark, Long keyword) {
		super();
		this.id = id;
		this.bookmark = bookmark;
		this.keyword = keyword;
	}

	public BookmarkKeywordConnection() {
		this(0l, null, null);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookmark() {
		return this.bookmark;
	}

	public void setBookmark(Long bookmark) {
		this.bookmark = bookmark;
	}

	public Long getKeyword() {
		return this.keyword;
	}

	public void setKeyword(Long keyword) {
		this.keyword = keyword;
	}

}
