package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.QuizDto;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import fr.dawan.myskills.exceptions.NotFoundException;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.QuizService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static fr.dawan.myskills.constants.ParamConstants.PAGE_SIZE;

@RestController
@RequestMapping("/quizzes")
public class QuizController extends GenericController<QuizDto, QuizService> implements AliasableController<QuizDto> {
	public QuizController(QuizService service) {
		super(service);
	}
	
	@Override
	@GetMapping("/alias/{alias}")
	public ResponseEntity<QuizDto> findByAlias(@PathVariable String alias) {
		return service.findByAlias(alias).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException(String.format("Aucun alias nommé '%s' dans les thèmes.",alias)));
	}
	
	@GetMapping("/theme/{themeId}")
	public ResponseEntity<Page<QuizDto>> findAllByThemeId(@PathVariable Long themeId, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findAllByThemeId(themeId,page));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Page<QuizDto>> findAllByNameContaining(@PathVariable String name, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findAllByNameContaining(name,page));
	}
	
	@GetMapping("/name/{name}{status}")
	public ResponseEntity<Page<QuizDto>> findAllByNameContainingAndStatus(@PathVariable String name, @PathVariable QuizStatusEnum status, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findAllByNameContainingAndStatus(name,status,page));
	}
	
	@GetMapping("/fav/{userId}")
	public ResponseEntity<Page<QuizDto>> findAllFavoriteFromUser(@PathVariable Long userId, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findAllFavoriteFromUser(userId,page));
	}
}
