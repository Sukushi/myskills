package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long>, AliasableRepository<Theme> {

}
