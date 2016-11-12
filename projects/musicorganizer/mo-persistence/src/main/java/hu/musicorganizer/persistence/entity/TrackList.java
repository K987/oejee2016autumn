package hu.musicorganizer.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tracklist")
public class TrackList {

	@Id
	@SequenceGenerator(name = "generatorTracklist", sequenceName = "tracklist_tracklist_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTracklist")
	@Column(name = "tracklist_id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tracklist_user_id", referencedColumnName = "user_id", nullable = false)
	private User user;
	
	@Column(name = "tracklist_name", nullable = false)
	private String name;

	public TrackList(Long id, User user, String name) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
