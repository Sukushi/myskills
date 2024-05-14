package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.UserAnswersDto;
import fr.dawan.myskills.entities.UserAnswers;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserAnswerMapper extends GenericMapper<UserAnswersDto, UserAnswers> {
}
