package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.AnswerDto;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.AnswerService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@MultipartConfig
@RestController
@RequestMapping()
public class AnswerController extends GenericController<AnswerDto, AnswerService> {

    public AnswerController(AnswerService service) {
        super(service);
    }
	
}
