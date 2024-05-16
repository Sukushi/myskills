package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.ImageDto;
import fr.dawan.myskills.generic.GenericService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface ImageService extends GenericService<ImageDto> {
	Optional<ImageDto> findBySource(String source);
	ImageDto save(MultipartFile file);
	ImageDto update(Long id, MultipartFile file);
	byte[] getImageBytes(String filename);

}
