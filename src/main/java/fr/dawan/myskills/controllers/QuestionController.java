package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.QuestionDto;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.QuestionService;
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
@RequestMapping("/questions")
public class QuestionController extends GenericController<QuestionDto, QuestionService> {
	public QuestionController(QuestionService service) {
		super(service);
	}
	
	@GetMapping("/text/{text}")
	public ResponseEntity<Page<QuestionDto>> findByTextContaining(@PathVariable String text, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findByTextContaining(text,page));
	}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<Page<QuestionDto>> findByQuizId(@PathVariable Long quizId, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findByQuizId(quizId,page));
	}
	
	@GetMapping("/theme/{themeId}")
	public ResponseEntity<Page<QuestionDto>> findByThemeId(@PathVariable Long themeId, @PageableDefault(size = PAGE_SIZE) Pageable page) {
		return ResponseEntity.ok(service.findByThemeId(themeId,page));
	}
}
