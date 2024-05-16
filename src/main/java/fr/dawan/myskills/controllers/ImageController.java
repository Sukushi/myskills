package fr.dawan.myskills.controllers;


import fr.dawan.myskills.dtos.ImageDto;

import fr.dawan.myskills.exceptions.ImageException;
import fr.dawan.myskills.generic.GenericController;

import fr.dawan.myskills.services.ImageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@RestController
@RequestMapping(value = "/image")
public class ImageController extends GenericController<ImageDto, ImageService> {

    public ImageController(ImageService service) {
        super(service);
    }

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageDto>save(@RequestParam(value = "file") MultipartFile file) throws Exception {
        ImageDto img = service.save(file);
        return new ResponseEntity<>(img, HttpStatus.CREATED);
    }

    @Override
    public void deleteById(@PathVariable long id) {
        try {
            service.delete(id);
        } catch (IOException e) {
            throw new ImageException("Image impossible a supprimer");
        }
    }

}
