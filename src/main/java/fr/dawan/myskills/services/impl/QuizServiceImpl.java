package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.QuizDto;
import fr.dawan.myskills.dtos.ThemeDto;
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
	public Page<QuizDto> findAllByThemeId(Long themeId, Pageable pageable) {
		return repository.findAllByThemeId(themeId,pageable).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllByNameContaining(String name, Pageable pageable) {
		return repository.findAllByNameContaining(name,pageable).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllByNameContainingAndStatus(String name, QuizStatusEnum status, Pageable pageable) {
		return repository.findAllByNameContainingAndStatus(name,status,pageable).map(mapper::toDto);
	}
	
	@Override
	public Page<QuizDto> findAllFavoriteFromUser(Long userId, Pageable pageable) {
		return repository.findAllFavoriteFromUser(userId,pageable).map(mapper::toDto);
	}
}
