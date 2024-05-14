package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends AliasableRepository<Category> {
	Optional<Category> findByName(String name);
}
