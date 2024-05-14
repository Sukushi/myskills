package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.QuizDto;
import fr.dawan.myskills.entities.Quiz;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuizMapper extends GenericMapper<QuizDto, Quiz> {
}
