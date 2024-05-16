package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.ImageDto;
import fr.dawan.myskills.entities.Image;
import fr.dawan.myskills.exceptions.DirectoryException;
import fr.dawan.myskills.exceptions.FileException;
import fr.dawan.myskills.exceptions.NotFoundException;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.ImageMapper;
import fr.dawan.myskills.repositories.ImageRepository;
import fr.dawan.myskills.services.ImageService;
import fr.dawan.myskills.tools.AliasGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static fr.dawan.myskills.constants.ParamConstants.*;

@Service
public class ImageServiceImpl extends GenericServiceImpl<Image, ImageDto, ImageRepository, ImageMapper> implements ImageService {
	public ImageServiceImpl(ImageRepository repository, ImageMapper mapper) {
		super(repository, mapper);
	}
	
	@Value("${images.directory.root:shared}")
	private String IMAGE_ROOT;
	
	@Override
	public Optional<ImageDto> findBySource(String source) {
		return repository.findBySource(source).map(mapper::toDto);
	}

	@Override
	public ImageDto saveOrUpdate(ImageDto dto) {
		throw new UnsupportedOperationException("Méthode non supporté");
	}

	@Override
	public List<ImageDto> saveAll(List<ImageDto> dtoList) {
		throw new UnsupportedOperationException("Méthode non supporté");
	}

	@Override
	public ImageDto save(MultipartFile multipartFile) {
		//on sauvegarde le chemin vers le fichier dans la BDD
		return mapper.toDto(repository.save(createOnServer(multipartFile)));
	}
	
	@Override
	public ImageDto update(Long id, MultipartFile multipartFile) {
		Optional<Image> imgOpt = repository.findById(id);
		if (imgOpt.isEmpty()) {
			throw new NotFoundException("Aucune image pour cette ID");
		}
		
		Image img = imgOpt.get();
		
		try {
			Files.delete(Paths.get(IMAGE_ROOT + File.separator + img.getSource()));
			Image savedOnServer = createOnServer(multipartFile);
			img.setOriginalFileName(savedOnServer.getOriginalFileName());
			img.setSource(savedOnServer.getSource());
			img.setMimeType(savedOnServer.getMimeType());
			
			return mapper.toDto(repository.saveAndFlush(img));
		} catch(IOException e) {
			throw new FileException();
		}
	}

	private Image createOnServer(MultipartFile multipartFile) {
		// 1- récupérer les données de l'image envoyée par le client
		String originalFilename = multipartFile.getOriginalFilename();
		// on appelle getMimeType au plus tôt car s'il y a erreur dans l'extension, on ne veut pas sauvegarder l'image
		String mimeType = getMimeType(originalFilename);
		try {
			if (multipartFile.getBytes().length > IMAGE_MAX_SIZE) {
				throw new IOException();
			}
		} catch(IOException e) {
			throw new FileException("Le fichier est trop volumineux");
		}
		
		// 2- on récupère un nom de fichier avec un format prédéfini pour notre serveur
		String normalizeName = AliasGenerator.normalize(originalFilename);
		if (repository.findBySource(normalizeName).isPresent()) {
			normalizeName = getFileNameNotUsed(normalizeName);
		}
		
		// 3- on sauvegarde le fichier sur le serveur
		File file = new File(IMAGE_ROOT + File.separator + normalizeName);
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				throw new DirectoryException("DIRECTORY MAKING PROBLEM");
			}
		}
		try {
			if(!file.createNewFile()) throw new FileException("Cannot create File");
			try (FileOutputStream fos = new FileOutputStream(file)) {
				fos.write(multipartFile.getBytes());
			}
		} catch(IOException e) {
			throw new FileException();
		}
		
		return new Image(normalizeName,originalFilename, mimeType);
	}
	
	private String getFileNameNotUsed(String fileName) {
		int increment = 1;
		fileName += "_";
		while (repository.findBySource(fileName+increment).isPresent()) {
			increment++;
		}
		return fileName + increment;
	}


	private String getMimeType(String fileName) {
		String ext = getFileExtension(fileName);
		String mimeType;
		if (ext == null)
			throw new FileException("no extension found");
		if (ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png") || ext.equals("gif")) {
			mimeType = "image/" + (ext.equals("jpg") ? "jpeg" : ext);
		} else if (ext.equals("svg")) {
			mimeType = "image/svg+xml";
		} else {
			throw new FileException(String.format("%s : extension not supported",ext));
		}
		return mimeType;
	}
	
	private String getFileExtension(String fileName) {
		String[] split = fileName.split("\\.");
		return split.length > 1 ? split[split.length - 1].toLowerCase() : null;
	}

	@Override
	public byte[] getImageBytes(String filename) {
		if (filename != null && repository.findBySource(filename).isPresent()) {
			File file = new File(IMAGE_ROOT + File.separator + filename);
			try {
				return Files.readAllBytes(file.toPath());
			} catch (IOException e) {
				throw new FileException();
			}
		} else {
			throw new FileException();
		}
	}

	@Override
	public void deleteById(long id) {
		Optional<ImageDto> img = findById(id);
		if (img.isPresent()) {
			try {
				Files.delete(Paths.get(IMAGE_ROOT + File.separator + img.get().getSource()));
				repository.deleteById(id);
			} catch (IOException e) {
				throw new FileException("Impossibilité De Supprimer");
			}
		}
	}

	/*public Optional<String> getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename)
				.filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}*/
}
