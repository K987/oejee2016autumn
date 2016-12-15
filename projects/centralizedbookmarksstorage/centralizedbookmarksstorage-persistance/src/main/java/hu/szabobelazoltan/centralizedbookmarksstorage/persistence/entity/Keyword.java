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
@Table(name = "cbms_keyword")
@NamedQueries(value = { @NamedQuery(name = BookmarkQuery.KEYWORD_BY_KW, query = "SELECT k FROM cbms_keyword k WHERE k.keyword=:" + BookmarkParameter.KEYWORD),
		@NamedQuery(name = BookmarkQuery.KEYWORD_ALL, query = "Select k FROM cbms_keyword k") })
public class Keyword implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8839141013550998878L;

	@Id
	@SequenceGenerator(name = "generatorBook", sequenceName = "cbms_keyword_keyword_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "keyword_id", nullable = false)
	private Long id;

	@Column(name = "keyword", nullable = false)
	private String keyword;

	public Keyword(Long id, String keyword) {
		super();
		this.id = id;
		this.keyword = keyword;
	}

	public Keyword() {
		this(0l, null);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
