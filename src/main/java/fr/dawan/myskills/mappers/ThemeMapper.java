package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.ThemeDto;
import fr.dawan.myskills.entities.Theme;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ThemeMapper extends GenericMapper<ThemeDto, Theme> {
}
