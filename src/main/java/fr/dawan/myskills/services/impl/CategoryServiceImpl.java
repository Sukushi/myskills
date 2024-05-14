package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.CategoryDto;
import fr.dawan.myskills.entities.Category;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.CategoryMapper;
import fr.dawan.myskills.repositories.CategoryRepository;
import fr.dawan.myskills.services.CategoryService;

public class CategoryServiceImpl extends AliasableServiceImpl<Category,CategoryDto,CategoryRepository,CategoryMapper> implements CategoryService {
	public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
		super(repository, mapper);
	}
}
