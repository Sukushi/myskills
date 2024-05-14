package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_categories")
public class Category extends BaseEntity implements AliasableEntity {
	
	@Column(nullable = false)
	private String name;
	private String alias;
	
	@Column(length = 65535, columnDefinition = "Text", nullable = true)
	private String description;
	
	private boolean visible;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnoreProperties(value = "categories")
	private Set<Theme> themes;
	
	@ManyToOne
	private Category categoryParent;
	
}
