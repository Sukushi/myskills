package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.ThemeDto;
import fr.dawan.myskills.entities.Theme;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.ThemeMapper;
import fr.dawan.myskills.repositories.ThemeRepository;
import fr.dawan.myskills.services.AliasableService;
import fr.dawan.myskills.services.ThemeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeServiceImpl extends GenericServiceImpl<Theme, ThemeDto, ThemeRepository, ThemeMapper> implements ThemeService, AliasableService<ThemeDto> {
	public ThemeServiceImpl(ThemeRepository repository, ThemeMapper mapper) {
		super(repository, mapper);
	}
	
	@Override
	public Optional<ThemeDto> findByAlias(String alias) {
		return repository.findByAlias(alias).map(mapper::toDto);
	}
}
