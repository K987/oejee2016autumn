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
@Table(name = "cbms_share_kw_connection")
@NamedQueries(value = { @NamedQuery(name = BookmarkQuery.CON_SHARE_KEYWORD_BY_KW, query = "SELECT c FROM cbms_share_kw_connection c WHERE c.Keyword=:"
		+ BookmarkParameter.KEYWORD_ID) })
public class ShareKeywordConnection implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6657992660907474563L;

	@Id
	@SequenceGenerator(name = "generatorBook", sequenceName = "cbms_share_kw_connection_connection_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "connection_id", nullable = false)
	private Long id;

	@Column(name = "cbms_share", nullable = false)
	private Long share;

	@Column(name = "keyword", nullable = false)
	private Long keyword;

	public ShareKeywordConnection(Long id, Long share, Long keyword) {
		super();
		this.id = id;
		this.share = share;
		this.keyword = keyword;
	}

	public ShareKeywordConnection() {
		this(0l, null, null);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShare() {
		return this.share;
	}

	public void setShare(Long share) {
		this.share = share;
	}

	public Long getKeyword() {
		return this.keyword;
	}

	public void setKeyword(Long keyword) {
		this.keyword = keyword;
	}

}
