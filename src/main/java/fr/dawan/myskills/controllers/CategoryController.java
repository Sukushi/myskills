package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.CategoryDto;
import fr.dawan.myskills.entities.Category;
import fr.dawan.myskills.exceptions.NotFoundException;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.AliasableService;
import fr.dawan.myskills.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController extends GenericController<CategoryDto, CategoryService> implements AliasableController<CategoryDto> {

    public CategoryController(CategoryService service) {
        super(service);
    }

    @Override
    @GetMapping(value = "/alias/{alias}")
    public ResponseEntity<CategoryDto> findByAlias(@PathVariable String alias) {
		return service.findByAlias(alias).map(ResponseEntity::ok).orElseThrow(() -> new NotFoundException(String.format("Aucun alias nommé '%s' dans les catégories.",alias)));
    }

}
