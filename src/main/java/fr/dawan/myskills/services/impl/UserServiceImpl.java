package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.UserDto;
import fr.dawan.myskills.entities.User;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.UserMapper;
import fr.dawan.myskills.repositories.UserRepository;
import fr.dawan.myskills.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserDto, UserRepository, UserMapper> implements UserService {
	public UserServiceImpl(UserRepository repository, UserMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Optional<UserDto> findByEmail(String email) {
		return repository.findByEmail(email).map(mapper::toDto);
	}
	
	@Override
	public Optional<UserDto> findByAuthToken(String token) {
		return repository.findByAuthToken(token).map(mapper::toDto);
	}
	
	@Override
	public Page<UserDto> findAllByAuthority(String authority, Pageable page) {
		return repository.findAllByAuthority(authority,page).map(mapper::toDto);
	}
}
