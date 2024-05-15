package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.UserAnswersDto;
import fr.dawan.myskills.entities.UserAnswers;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.UserAnswerMapper;
import fr.dawan.myskills.repositories.UserAnswersRepository;
import fr.dawan.myskills.services.UserAnswersService;
import org.springframework.stereotype.Service;

@Service
public class UserAnswersServiceImpl extends GenericServiceImpl<UserAnswers, UserAnswersDto, UserAnswersRepository, UserAnswerMapper> implements UserAnswersService {
	public UserAnswersServiceImpl(UserAnswersRepository repository, UserAnswerMapper mapper) {
		super(repository, mapper);
	}
}
