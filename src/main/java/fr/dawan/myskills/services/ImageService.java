package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.ImageDto;
import fr.dawan.myskills.generic.GenericService;

import java.util.Optional;

public interface ImageService extends GenericService<ImageDto> {
	Optional<ImageDto> findBySource(String source);
}
