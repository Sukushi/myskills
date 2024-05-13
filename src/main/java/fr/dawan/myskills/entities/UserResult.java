package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_UserResult")
public class UserResult extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id", nullable = false)
	@JsonBackReference("quiz_quizDone")
	private Quiz quiz;
	
	@ManyToOne
	@JsonBackReference("User_QuizDone")
	@JoinColumn(name = "user_id", nullable = true)
	private User user;
	
	private double score;
	
	private LocalDateTime date;
	
	private boolean valid;
	
	private int total;
	
	private String username;
	
	@OneToMany(mappedBy = "userResult", cascade = CascadeType.ALL)
	private List<UserAnswers> userAnswers;
	
}
