package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.CategoryDto;
import fr.dawan.myskills.entities.Category;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper extends GenericMapper<CategoryDto, Category> {
}
