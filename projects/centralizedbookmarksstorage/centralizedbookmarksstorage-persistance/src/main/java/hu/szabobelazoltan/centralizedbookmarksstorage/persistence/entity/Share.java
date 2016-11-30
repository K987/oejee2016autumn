package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "cbms_share")
@NamedQueries(value = {
		@NamedQuery(name = BookmarkQuery.SHARE_BY_DATE, query = "SELECT s FROM cbms_share st WHERE s.share_date=:" + BookmarkParameter.SHARE_DATE),
		@NamedQuery(name = BookmarkQuery.BOOKMARK_BY_ID, query = "SELECT s FROM cbms_share st WHERE s.share_bookmark=:" + BookmarkParameter.BOOKMARK_ID),
		@NamedQuery(name = BookmarkQuery.SHARE_BY_KEYWORD, query = "SELECT s FROM cbms_share st, (Select cbms_share_kw_connecton.share sh FROM cbms_share_kw_connecton RIGHT JOIN cbms_keyword ON cbms_share_kw_connection.keyword = cbms_keyword.keywor_id WHERE cbms_keyword.keyword=:'"
				+ BookmarkParameter.KEYWORD + "') AS KWFIND WHERE cbms_share.share_id = KWFIND.sh") })
public class Share implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8005827540581664962L;

	@Id
	@SequenceGenerator(name = "generatorBook", sequenceName = "cbms_share_share_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "share_id", nullable = false)
	private Long id;

	@Column(name = "share_date", nullable = false)
	private Date date;

	@Column(name = "share_bookmark", nullable = false)
	private Long bookmark;

	public Share(Long id, Date date, Long bookmark) {
		super();
		this.id = id;
		this.date = date;
		this.bookmark = bookmark;
	}

	public Share() {
		this(0l, null, 0l);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getBookmark() {
		return this.bookmark;
	}

	public void setBookmark(Long bookmark) {
		this.bookmark = bookmark;
	}

}
