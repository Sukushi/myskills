package fr.dawan.myskills.controllers;

import fr.dawan.myskills.dtos.CoordinatesDto;
import fr.dawan.myskills.generic.GenericController;
import fr.dawan.myskills.services.CoordinatesService;

public class CoordinatesController extends GenericController<CoordinatesDto, CoordinatesService> {
    public CoordinatesController(CoordinatesService service) {
        super(service);
    }
}
