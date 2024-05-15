package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.UserResultDto;
import fr.dawan.myskills.entities.UserResult;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.UserResultMapper;
import fr.dawan.myskills.repositories.UserResultRepository;
import fr.dawan.myskills.services.UserResultService;

public class UserResultServiceImpl extends GenericServiceImpl<UserResult, UserResultDto, UserResultRepository, UserResultMapper> implements UserResultService {
	public UserResultServiceImpl(UserResultRepository repository, UserResultMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Integer countByUserId(Long userId) {
		return repository.countByUserId(userId);
	}
}
