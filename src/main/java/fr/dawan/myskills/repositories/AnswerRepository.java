package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByImgId(Long imageId);

    @Modifying
    @Query("UPDATE Answer a SET a.img = NULL WHERE a.img.id = :id")
    void deleteImageAnswer(long id);


    @Modifying
    @Query("UPDATE UserAnswers a SET a.img = NULL WHERE a.img.id = :id")
    void deleteImageUserAnswer(long id);
}
