package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.ImageDto;
import fr.dawan.myskills.entities.Image;
import fr.dawan.myskills.exceptions.FileException;
import fr.dawan.myskills.exceptions.ImageException;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.mappers.ImageMapper;
import fr.dawan.myskills.services.ImageService;
import fr.dawan.myskills.services.impl.AnswerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/image")
public class ImageController extends GenericController<ImageDto, ImageService> {
    private static final Logger log = LoggerFactory.getLogger(ImageController.class);
    private final AnswerServiceImpl answerServiceImpl;

    public ImageController(ImageService service, AnswerServiceImpl answerServiceImpl) {
        super(service);
        this.answerServiceImpl = answerServiceImpl;
    }

    @GetMapping(value = "/fileOne/{id}")
    public ResponseEntity<ImageDto> getImage(@PathVariable long id) throws Exception {
        Optional<ImageDto> image = service.findById(id);
        if (image.isPresent())
            return ResponseEntity.ok(image.get());
        else
            throw new Exception("No image found");
    }

    @GetMapping(value = "/file/{id}")
    public ResponseEntity<byte[]> getImageFile(@PathVariable long id) throws Exception {
        Optional<ImageDto> image = service.findById(id);
        if (image.isEmpty()) throw new FileException("NO FILE");
        byte[] array = service.getImageBytes(image.get().getSource());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", image.get().getMimeType());
        return new ResponseEntity<>(array, headers, HttpStatus.OK);
    }
    @GetMapping(value = "/")
    public ResponseEntity<byte[]> getOneInByte(@RequestParam String file) throws Exception {
        byte[] array = service.getImageBytes(file);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", service.getMimeType(file));
        return new ResponseEntity<>(array, headers, HttpStatus.OK);
    }


    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageDto>save(@RequestParam(value = "file") MultipartFile file) throws Exception {
        ImageDto img = service.save(file);
        return new ResponseEntity<>(img, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        long answerId = answerServiceImpl.findByImg(id);
        if (answerId > 0) {
            answerServiceImpl.deleteImage(answerId);
        }
        boolean deleted = service.delete(id);
        if (deleted) {
            return new ResponseEntity<>("Image supprimé", HttpStatus.OK);
        } else throw new ImageException(id.toString());
    }

}
