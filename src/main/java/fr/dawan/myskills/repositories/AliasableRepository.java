package fr.dawan.myskills.repositories;

import java.util.Optional;

public interface AliasableRepository<E> {
	Optional<E> findByAlias(String alias);
}
