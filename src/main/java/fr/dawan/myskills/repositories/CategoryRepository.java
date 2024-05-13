package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, AliasableRepository<Category> {
	Category findByName(String name);
}
