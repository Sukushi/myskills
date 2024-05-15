package fr.dawan.myskills.dtos;

import java.time.LocalDateTime;

public class AuditLogEntryDto extends BaseEntityDto {
	private String entityName;
	
	private String entityId;
	
	private LocalDateTime creationDate = LocalDateTime.now();
	
	private String auditEntryType;
	
	private String fieldName;
	
	private String oldValue;
	
	private String newValue;
}
