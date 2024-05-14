package fr.dawan.myskills.entities;


public interface AliasableEntity {
	// Category | Quiz | Theme
	// les trois classes ont un alias qui sera géré de la même manière
	
	String getAlias();
	AliasableEntity setAlias(String alias);
	
}
