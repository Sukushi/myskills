package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	Optional<Question> findByText(String text);
	
	/**
	 * Recherche paginée des questions qui contiennent le mot clé dans leur texte
	 * @param text
	 * @param page
	 * @return Une page de {@link Question} dont le texte contient le terme
	 */
	Page<Question> findByTextContaining(String text, Pageable page);
	
	/**
	 * Retourne toutes les questions qui sont liées au quiz dont on passe l'id
	 * @param quizId
	 * @param page
	 * @return Une page de {@link Question} liée à un Quiz
	 */
	@Query("SELECT q FROM Question q JOIN q.quizzes qu WHERE qu.id = :quizId")
	Page<Question> findByQuizId(@Param("quizId") Long quizId, Pageable page);
	
	/**
	 * Retourne toutes les questions qui sont liées au thème dont on passe l'id
	 * @param themeId
	 * @param page
	 * @return Une page de {@link Question} liée à un Theme
	 */
	@Query("SELECT q FROM Question q JOIN q.themes t WHERE t.id = :themeId")
	Page<Question> findByThemeId(@Param("themeId") Long themeId, Pageable page);
}
