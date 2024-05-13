package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_answers")
public class Answer extends BaseEntity {
	
	@Column(length = 65535, columnDefinition = "Text")
	private String text;
	
	private boolean correct;
	
	@ToString.Exclude
	@OneToOne(cascade = CascadeType.REMOVE)
	private Image img;
	
	@ToString.Exclude
	@JsonBackReference
	@ManyToOne
	private Question question;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE)
	private List<Coordinates> coordinates;
	
}
