package fr.dawan.myskills.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@ToString

@Entity
@Table(name = "t_auditlogs")
public class AuditLogEntry extends BaseEntity {
	
	private String entityName;
	
	private String entityId;
	
	private LocalDateTime creationDate = LocalDateTime.now();
	
	private String auditEntryType;
	
	private String fieldName;
	
	private String oldValue;
	
	private String newValue;
	
}
