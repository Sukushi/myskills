package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	Image findBySource(String source);
}
