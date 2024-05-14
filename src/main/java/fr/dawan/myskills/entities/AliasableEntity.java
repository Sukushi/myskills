package fr.dawan.myskills.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
public abstract class AliasableEntity extends BaseEntity {
	// Category | Quiz | Theme
	// les trois classes ont un alias qui sera géré de la même manière
	
	String alias;
	
}
