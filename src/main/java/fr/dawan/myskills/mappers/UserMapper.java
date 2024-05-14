package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.UserDto;
import fr.dawan.myskills.entities.User;
import fr.dawan.myskills.tools.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends GenericMapper<UserDto, User> {
}
