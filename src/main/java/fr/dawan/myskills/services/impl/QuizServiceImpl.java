package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.QuizDto;
import fr.dawan.myskills.entities.Quiz;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.QuizMapper;
import fr.dawan.myskills.repositories.QuizRepository;
import fr.dawan.myskills.services.AliasableService;
import fr.dawan.myskills.services.QuizService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizServiceImpl extends GenericServiceImpl<Quiz, QuizDto, QuizRepository, QuizMapper> implements QuizService, AliasableService<QuizDto> {
	public QuizServiceImpl(QuizRepository repository, QuizMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Optional<QuizDto> findByAlias(String alias) {
		return repository.findByAlias(alias).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllByThemeId(Long themeId, Pageable page) {
		return repository.findAllByThemeId(themeId,page).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllByNameContaining(String name, Pageable page) {
		return repository.findAllByNameContaining(name,page).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllByNameContainingAndStatus(String name, QuizStatusEnum status, Pageable page) {
		return repository.findAllByNameContainingAndStatus(name,status,page).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllFavoriteFromUser(Long userId, Pageable page) {
		return repository.findAllFavoriteFromUser(userId,page).map(mapper::toDto);
	}
}
