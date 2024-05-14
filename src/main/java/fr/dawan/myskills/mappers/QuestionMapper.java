package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.QuestionDto;
import fr.dawan.myskills.entities.Question;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper extends GenericMapper<QuestionDto, Question> {
}
