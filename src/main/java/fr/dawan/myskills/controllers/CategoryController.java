package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.CategoryDto;
import fr.dawan.myskills.entities.Category;
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
@RequestMapping(value = "/category")
public class CategoryController extends GenericController<CategoryDto, CategoryService> implements AliasableController<CategoryDto> {

    public CategoryController(CategoryService service) {
        super(service);
    }

    @Override
    @GetMapping(value = "/alias/{categoryAlias}")
    public Optional<CategoryDto> findByAlias(@PathVariable String categoryAlias) {
        return service.findByAlias(categoryAlias);
    }
    @PostMapping(value = "/admin")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(service.saveOrUpdate(categoryDto), HttpStatus.CREATED);
    }


}
