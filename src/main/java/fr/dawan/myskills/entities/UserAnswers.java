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
@Table(name = "t_user_answers")
public class UserAnswers extends BaseEntity{
	
	private String text;
	
	private boolean correct;
	
	@OneToOne
	private Image img;
	
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "question_id")
	private Question question;
	
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userResult_id")
	private UserResult userResult;
	
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coordinates_id")
	private Coordinates coordinates;
}
