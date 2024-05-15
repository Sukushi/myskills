package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.UserAnswersDto;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.UserAnswersService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@MultipartConfig
@RestController
@RequestMapping("/userAnswers")
public class UserAnswerController extends GenericController<UserAnswersDto, UserAnswersService> {
	public UserAnswerController(UserAnswersService service) {
		super(service);
	}
}
