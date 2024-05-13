package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, AliasableRepository<Category> {
	Optional<Category> findByName(String name);
}
