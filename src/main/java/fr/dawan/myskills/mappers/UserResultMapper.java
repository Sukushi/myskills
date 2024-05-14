package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.UserResultDto;
import fr.dawan.myskills.entities.UserResult;
import fr.dawan.myskills.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserResultMapper extends GenericMapper<UserResultDto, UserResult> {
}
