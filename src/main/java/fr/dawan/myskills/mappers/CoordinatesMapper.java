package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.CoordinatesDto;
import fr.dawan.myskills.entities.Coordinates;
import fr.dawan.myskills.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CoordinatesMapper extends GenericMapper<CoordinatesDto, Coordinates> {
}
