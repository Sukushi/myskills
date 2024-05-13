package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswersRepository extends JpaRepository<UserAnswers, Long> {
}
