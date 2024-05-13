package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.UserResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResultRepository extends JpaRepository<UserResult, Long> {
	
	/**
	 * Récupère le nombre de quizzes passés par un utilisateur
	 *
	 * @param userId l'id de l'utilisateur
	 * @return nombre de quizzes passés par l'utilisateur
	 */
	Integer countByUserId(Long userId);
}
