package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.QuestionDto;
import fr.dawan.myskills.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService extends GenericService<QuestionDto> {
	Page<QuestionDto> findByTextContaining(String text, Pageable page);
	Page<QuestionDto> findByQuizId(Long quizId, Pageable page);
	Page<QuestionDto> findByThemeId(Long themeId, Pageable page);
}
