package ${package}.domain;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "user")
@NamedQuery(name = User.FIND_BY_USERNAME, query = "select u from User u where u.username = :username")
public class User {

	public static final String FIND_BY_USERNAME = "User.findByUsername";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;
	
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";
	
	private String name;
	
	protected User() {

	}
	
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
