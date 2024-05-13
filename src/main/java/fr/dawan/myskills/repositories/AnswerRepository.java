package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
