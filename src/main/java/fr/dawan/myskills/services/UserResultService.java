package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.UserResultDto;
import fr.dawan.myskills.generic.GenericService;

public interface UserResultService extends GenericService<UserResultDto> {
	Integer countByUserId(Long userId);
}
