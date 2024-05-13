package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.dawan.myskills.entities.enums.LevelEnum;
import fr.dawan.myskills.entities.enums.QuestionStatusEnum;
import fr.dawan.myskills.entities.enums.QuestionTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_questions")
public class Question extends BaseEntity {
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Image img;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private QuestionStatusEnum status;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private QuestionTypeEnum type;
	
	@Enumerated(EnumType.STRING)
	private LevelEnum level;
	
	@Column(columnDefinition = "Text")
	String qstKeywords;
	
	/**
	 * Correctif affiché, à la fin d'un quiz-game, à un membre chaque fois que ces
	 * derniers aient fourni une mauvaise réponse.
	 */
	@Column(columnDefinition = "Text")
	String explanation;
	
	@EqualsAndHashCode.Exclude
	@Column
	LocalDateTime creationDate;
	
	int time;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	List<Answer> answers;
	
	@OneToMany(mappedBy = "question")
	@JsonManagedReference
	List<UserAnswers> userAnswers;
	
	@ManyToMany
	private Set<Quiz> quizzes;
	
	@ManyToMany
	private Set<Theme> themes;
	
}
