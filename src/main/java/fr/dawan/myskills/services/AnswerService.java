package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.AnswerDto;
import fr.dawan.myskills.generic.GenericService;

public interface AnswerService extends GenericService<AnswerDto> {
    public Long findByImg(long imageId);
    public void deleteImage(long id);
}
