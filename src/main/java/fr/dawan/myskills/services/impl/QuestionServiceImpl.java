package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.QuestionDto;
import fr.dawan.myskills.entities.Question;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.QuestionMapper;
import fr.dawan.myskills.repositories.QuestionRepository;
import fr.dawan.myskills.services.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl extends GenericServiceImpl<Question, QuestionDto, QuestionRepository, QuestionMapper> implements QuestionService {
	public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Page<QuestionDto> findByTextContaining(String text, Pageable page) {
		return repository.findByTextContaining(text,page).map(mapper::toDto);
	}
	
	@Override
	public Page<QuestionDto> findByQuizId(Long quizId, Pageable page) {
		return repository.findByQuizId(quizId,page).map(mapper::toDto);
	}
	
	@Override
	public Page<QuestionDto> findByThemeId(Long themeId, Pageable page) {
		return repository.findByThemeId(themeId,page).map(mapper::toDto);
	}
}
