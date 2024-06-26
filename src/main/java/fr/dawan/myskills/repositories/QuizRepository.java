package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Quiz;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>, AliasableRepository<Quiz> {
	Page<Quiz> findAllByThemeId(Long themeId, Pageable page);
	
	/**
	 * Recherche paginée des quizzes qui contiennent le mot clé dans leur nom
	 * @see #findAllByNameContainingAndStatus (String, QuizStatusEnum, Pageable) En fonction de leur statut
	 * @param name
	 * @param page
	 * @return
	 */
	Page<Quiz> findAllByNameContaining(String name, Pageable page);
	
	Page<Quiz> findAllByNameContainingAndStatus(String name, QuizStatusEnum status, Pageable page);
	
	@Query(value = "SELECT * FROM t_quiz q left join t_users_quiz_favorite uqf ON uqf.quiz_favorite_id = q.id WHERE uqf.user_favorite_id = :userId", nativeQuery = true)
	Page<Quiz> findAllFavoriteFromUser(Long userId, Pageable page);
	
}
