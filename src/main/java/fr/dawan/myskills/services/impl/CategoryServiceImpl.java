package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.CategoryDto;
import fr.dawan.myskills.entities.Category;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.CategoryMapper;
import fr.dawan.myskills.repositories.CategoryRepository;
import fr.dawan.myskills.services.AliasableService;
import fr.dawan.myskills.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category,CategoryDto,CategoryRepository,CategoryMapper> implements CategoryService, AliasableService<CategoryDto> {
	public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Optional<CategoryDto> findByAlias(String alias) {
		return repository.findByAlias(alias).map(mapper::toDto);
	}
}
