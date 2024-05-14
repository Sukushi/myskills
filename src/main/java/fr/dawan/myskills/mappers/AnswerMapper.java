package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.AnswerDto;
import fr.dawan.myskills.entities.Answer;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper extends GenericMapper<AnswerDto, Answer> {
}
