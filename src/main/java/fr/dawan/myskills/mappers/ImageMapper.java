package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.ImageDto;
import fr.dawan.myskills.entities.Image;
import fr.dawan.myskills.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper extends GenericMapper<ImageDto, Image> {
}
