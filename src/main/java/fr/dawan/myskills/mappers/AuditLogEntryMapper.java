package fr.dawan.myskills.mappers;

import fr.dawan.myskills.dtos.AuditLogEntryDto;
import fr.dawan.myskills.entities.AuditLogEntry;
import fr.dawan.myskills.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuditLogEntryMapper extends GenericMapper<AuditLogEntryDto, AuditLogEntry> {
}
