package hu.musicorganizer.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tracklist")
public class Tracklist {

	@Id
	@SequenceGenerator(name = "generatorTracklist", sequenceName = "tracklist_tracklist_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTracklist")
	@Column(name = "tracklist_id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "tracklist_customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customer;
	
	@Column(name = "tracklist_name", nullable = false)
	private String name;

	public Tracklist() {
		super();
	}
	
	public Tracklist(Customer customer, String name) {
		super();
		this.customer = customer;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer user) {
		this.customer = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
