package fr.dawan.myskills.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_images")
public class Image extends BaseEntity {
	
	@Column
	private String source; // nom du fichier stocké
	
	private String originalFileName; // nom d'origine du fichier (pour référence)
	
	private String mimeType; // type mime pour faciliter le traitement par les controllers
	
	@PreRemove
	private void preRemove() {
		// TODO : Supprimer le fichier image physique du système de fichiers ou du stockage cloud...
	}
}
