package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.AliasableDto;
import fr.dawan.myskills.entities.AliasableEntity;
import fr.dawan.myskills.entities.BaseEntity;
import fr.dawan.myskills.generic.GenericMapper;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.AliasableMapper;
import fr.dawan.myskills.repositories.AliasableRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AliasableServiceImpl<E extends AliasableEntity,D extends AliasableDto,
				R extends AliasableRepository<E>,
				M extends AliasableMapper<D,E>>
		extends GenericServiceImpl<E, D, R, M> {
	public AliasableServiceImpl(R repository, M mapper) {
		super(repository, mapper);
	}
}
