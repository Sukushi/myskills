package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_theme")
public class Theme extends BaseEntity implements AliasableEntity {
	
	private String name;
	private String alias;
	
	private String description;
	
	private String icon;
	
	@ManyToOne
	private Theme themeParent;
	
	@ManyToMany
	@JsonIgnoreProperties(value = "themes")
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "theme")
	private Set<Quiz> quizzes = new HashSet<>();
	
	@ManyToMany(mappedBy = "themes")
	private Set<Question> questions = new HashSet<>();
}
