package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.AliasableDto;

import java.util.Optional;

public interface AliasableService<D extends AliasableDto> {
	Optional<D> findByAlias(String alias);
}
