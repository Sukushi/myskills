package fr.dawan.myskills.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.dawan.myskills.entities.enums.LevelEnum;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "t_quiz")
public class Quiz extends BaseEntity implements AliasableEntity {
	
	private String name;
	private String alias;
	
	@Enumerated(EnumType.STRING)
	private QuizStatusEnum status;
	
	@Enumerated(EnumType.STRING)
	private LevelEnum level;
	
	private boolean accessibleByLink;
	
	// globalChronoActivated :
	// true : temps global pour le quizz, possibilité de revenir en arrière
	// false : chrono par question, pas de retour arrière possible
	private boolean globalChronoActivated;
	
	// durée totale allouée pour répondre au quizz (en secondes)
	private int globalChrono;
	
	private int nbQuestions;
	
	private boolean showResults;
	
	@ManyToMany(mappedBy = "quizzes")
	private Set<Question> questions;
	
	@JsonManagedReference("quiz_quizDone")
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.REMOVE)
	private Set<UserResult> userResults;
	
	@ManyToOne
	private Theme theme;
	
	@ManyToMany(mappedBy = "quizFavorite")
	private Set<User> userFavorite;
	
	@ManyToOne
	@JoinColumn(name = "linkCreator_id")
	private User linkCreator;
}
