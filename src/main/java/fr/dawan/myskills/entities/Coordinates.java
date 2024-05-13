package fr.dawan.myskills.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_coordinates")
public class Coordinates extends BaseEntity{
	
	private int x;
	
	private int y;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "answer_id")
	private Answer answer;
	
}
