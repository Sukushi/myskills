package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.AliasableEntity;

import java.util.Optional;

public interface AliasableRepository<E extends AliasableEntity> {
	Optional<E> findByAlias(String alias);
}
