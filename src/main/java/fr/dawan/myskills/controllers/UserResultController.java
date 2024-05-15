package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.UserResultDto;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.UserResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userResults")
public class UserResultController extends GenericController<UserResultDto, UserResultService> {
	public UserResultController(UserResultService service) {
		super(service);
	}
	
	@GetMapping("/count/{id}")
	public ResponseEntity<Integer> countByUserId(@PathVariable Long id) {
		return ResponseEntity.ok(service.countByUserId(id));
	}
}
