package fr.dawan.myskills.services;

import fr.dawan.myskills.dtos.UserDto;
import fr.dawan.myskills.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService extends GenericService<UserDto> {
	Optional<UserDto> findByEmailAndAuthTokenAndEnabled(String email, String token, boolean enabled);
	Optional<UserDto> findByEmail(String email);
	Optional<UserDto> findByAuthToken(String token);
	Page<UserDto> findAllByAuthority(String authority, Pageable page);
}
