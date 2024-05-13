package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.dawan.myskills.entities.enums.Title;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_users")
public class User extends BaseEntity implements UserDetails {
	
	@ToString.Include
	@Column(length = 50)
	private String username;
	
	// Identifiants de connexion Email + password
	@ToString.Include
	@Column(nullable = false)
	private String email;
	
	//   @JsonIgnore
	@ToString.Include
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Title title;
	
	@ToString.Include
	@Column(length = 50)
	private String firstName;
	
	@ToString.Include
	@Column(length = 50)
	private String lastName;
	
	private int workExperience;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime validationDate;
	
	@JsonIgnore
	private boolean enabled;
	
	@JsonIgnore
	private boolean accountNonLocked;
	
	@JsonIgnore
	private boolean credentialsNonExpired;
	
	@JsonIgnore
	private boolean accountNonExpired;
	
	@Column(nullable = false)
	private boolean submitter;
	
	@JsonIgnore
	@Column(columnDefinition = "Text")
	private String authToken;
	
	@JsonIgnore
	private String phone;
	
	private String role;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Image avatar;
	
	private String socialNetworkAvatarURL;
	
	@Column(columnDefinition = "Text")
	private String socialNetworkAuthToken;
	
	//   @JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Authority> authorities = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference("User_QuizDone")
	private List<UserResult> userResult;
	
	@ManyToMany
	private Set<Quiz> quizFavorite;
	
	public User(String username, String password, Title title, @NotEmpty @Size(min = 3, max = 25) String firstName,
				String lastName, boolean accountNonLocked, String role, String email) {
		this.username = username;
		this.password = password;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNonLocked = accountNonLocked;
		this.role = role;
		this.email = email;
	}
	
	@Override
	public boolean isEnabled() {
		return this.isCredentialsNonExpired() && this.isAccountNonLocked() && this.isAccountNonExpired();
	}
}
