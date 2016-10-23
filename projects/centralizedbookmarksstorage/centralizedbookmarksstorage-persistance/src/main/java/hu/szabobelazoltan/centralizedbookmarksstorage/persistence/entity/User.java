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
@Table(name = "cbms_user")
@NamedQueries(value = {
		@NamedQuery(name = BookmarkQuery.SHARE_BY_DATE, query = "SELECT u FROM cbms_user u WHERE u.user_name=:" + BookmarkParameter.USER_NAME), })
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2052666694507518670L;

	@Id
	@SequenceGenerator(name = "generatorBook", sequenceName = "cbms_user_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorBook")
	@Column(name = "user_id", nullable = false)
	private Long id;

	@Column(name = "user_name", nullable = false)
	private String name;

	@Column(name = "user_pw", nullable = false)
	private String password;

	@Column(name = "user_email", nullable = false)
	private String email;

	public User(Long id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public User() {
		this(0l, null, null, null);
	}

}
