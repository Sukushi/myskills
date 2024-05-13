package fr.dawan.myskills.repositories;

public interface AliasableRepository<E> {
	E findByAlias(String alias);
}
