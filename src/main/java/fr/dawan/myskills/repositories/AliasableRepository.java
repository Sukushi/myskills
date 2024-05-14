package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.AliasableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AliasableRepository<E extends AliasableEntity> extends JpaRepository<E,Long> {
	Optional<E> findByAlias(String alias);
}
