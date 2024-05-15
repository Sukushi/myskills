package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.ThemeDto;
import fr.dawan.myskills.exceptions.NotFoundException;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/themes")
public class ThemeController extends GenericController<ThemeDto, ThemeService> implements AliasableController<ThemeDto> {
	public ThemeController(ThemeService service) {
		super(service);
	}
	
	
	@Override
	@GetMapping("/alias/{alias}")
	public ResponseEntity<ThemeDto> findByAlias(@PathVariable String alias) {
		return service.findByAlias(alias).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException(String.format("Aucun alias nommé '%s' dans les thèmes.",alias)));
	}
}
