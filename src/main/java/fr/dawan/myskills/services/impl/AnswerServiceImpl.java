package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.AnswerDto;
import fr.dawan.myskills.entities.Answer;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.AnswerMapper;
import fr.dawan.myskills.repositories.AnswerRepository;
import fr.dawan.myskills.services.AnswerService;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl extends GenericServiceImpl<Answer,AnswerDto,AnswerRepository,AnswerMapper> implements AnswerService {
	public AnswerServiceImpl(AnswerRepository repository, AnswerMapper mapper) {
		super(repository, mapper);
	}
}
