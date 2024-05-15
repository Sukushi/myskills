package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.AuditLogEntryDto;
import fr.dawan.myskills.entities.AuditLogEntry;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.AuditLogEntryMapper;
import fr.dawan.myskills.repositories.AuditLogEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditLogEntryServiceImpl extends GenericServiceImpl<AuditLogEntry, AuditLogEntryDto, AuditLogEntryRepository, AuditLogEntryMapper> {
	public AuditLogEntryServiceImpl(AuditLogEntryRepository repository, AuditLogEntryMapper mapper) {
		super(repository, mapper);
	}
}
