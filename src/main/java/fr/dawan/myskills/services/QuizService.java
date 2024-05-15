package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.QuizDto;
import fr.dawan.myskills.dtos.ThemeDto;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import fr.dawan.myskills.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizService extends GenericService<QuizDto> {
	Page<QuizDto> findAllByThemeId(Long themeId, Pageable pageable);
	
	Page<QuizDto> findAllByNameContaining(String name, Pageable pageable);
	
	Page<QuizDto> findAllByNameContainingAndStatus(String name, QuizStatusEnum status, Pageable pageable);
	
	Page<QuizDto> findAllFavoriteFromUser(Long userId, Pageable pageable);
}
