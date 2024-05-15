package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.QuizDto;
import fr.dawan.myskills.dtos.ThemeDto;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import fr.dawan.myskills.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizService extends GenericService<QuizDto>, AliasableService<QuizDto> {
	Page<QuizDto> findAllByThemeId(Long themeId, Pageable page);
	
	Page<QuizDto> findAllByNameContaining(String name, Pageable page);
	
	Page<QuizDto> findAllByNameContainingAndStatus(String name, QuizStatusEnum status, Pageable page);
	
	Page<QuizDto> findAllFavoriteFromUser(Long userId, Pageable page);
}
