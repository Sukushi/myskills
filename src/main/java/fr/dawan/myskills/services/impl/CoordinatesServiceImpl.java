package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.CoordinatesDto;
import fr.dawan.myskills.entities.Coordinates;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.CoordinatesMapper;
import fr.dawan.myskills.repositories.CoordinatesRepository;
import fr.dawan.myskills.services.CoordinatesService;

public class CoordinatesServiceImpl extends GenericServiceImpl<Coordinates, CoordinatesDto, CoordinatesRepository, CoordinatesMapper> implements CoordinatesService {
	public CoordinatesServiceImpl(CoordinatesRepository repository, CoordinatesMapper mapper) {
		super(repository, mapper);
	}
}
