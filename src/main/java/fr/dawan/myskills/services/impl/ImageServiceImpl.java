package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.ImageDto;
import fr.dawan.myskills.entities.Image;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.ImageMapper;
import fr.dawan.myskills.repositories.ImageRepository;
import fr.dawan.myskills.services.ImageService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl extends GenericServiceImpl<Image, ImageDto, ImageRepository, ImageMapper> implements ImageService {
	public ImageServiceImpl(ImageRepository repository, ImageMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Optional<ImageDto> findBySource(String source) {
		return repository.findBySource(source).map(mapper::toDto);
	}
}
