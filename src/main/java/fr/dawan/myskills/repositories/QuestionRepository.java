package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findByText(String text);
	
	Page<Question> findByTextContainingIgnoreCase(String text, Pageable pageable);
	
	@Query("SELECT q FROM Question q JOIN q.quizzes qu WHERE qu.id = :quizId")
	Page<Question> findByQuizId(@Param("quizId") Long quizId, Pageable pageable);
	
	@Query("SELECT q FROM Question q JOIN q.themes t WHERE t.id = :themeId")
	Page<Question> findByThemeId(@Param("themeId") Long themeId, Pageable pageable);
}
