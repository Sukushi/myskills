package fr.dawan.myskills.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogEntryDto extends BaseEntityDto {
	private String entityName;
	
	private String entityId;
	
	private LocalDateTime creationDate = LocalDateTime.now();
	
	private String auditEntryType;
	
	private String fieldName;
	
	private String oldValue;
	
	private String newValue;
}
