package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.UserDto;
import fr.dawan.myskills.exceptions.NotFoundException;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.UserService;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@MultipartConfig
@RestController
@RequestMapping("/users")
public class UserController extends GenericController<UserDto, UserService> {
	public UserController(UserService service) {
		super(service);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserDto> findByEmail(@PathVariable String email) {
		// .map(u -> new ResponseEntity<>(u,HttpStatus.OK))
		return service.findByEmail(email).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException(String.format("L'email %s ne correspond à aucun utilisateur.", email)));
	}
	
	@GetMapping("/{token}")
	public ResponseEntity<UserDto> findByAuthToken(@PathVariable String token) {
		// .map(u -> new ResponseEntity<>(u,HttpStatus.OK))
		return service.findByAuthToken(token).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException(String.format("Le token %s ne correspond à aucun utilisateur.", token)));
	}
	
	@GetMapping("/all/{authority}")
	public ResponseEntity<Page<UserDto>> findAllByAuthority(@PathVariable String authority, @PageableDefault(size = 20, page = 0) Pageable page) {
		return ResponseEntity.ok(service.findAllByAuthority(authority,page));
	}
}
