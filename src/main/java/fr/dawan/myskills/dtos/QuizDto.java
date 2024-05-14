package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.Theme;
import fr.dawan.myskills.entities.User;
import fr.dawan.myskills.entities.UserResult;
import fr.dawan.myskills.entities.enums.LevelEnum;
import fr.dawan.myskills.entities.enums.QuizStatusEnum;
import lombok.*;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class QuizDto extends BaseEntityDto implements AliasableDto {
    private String name;
	private String alias;
    private QuizStatusEnum status;
    private LevelEnum level;
    private boolean accessibleByLink;
    private boolean globalChronoActivated;
    private int globalChrono;
    private int nbQuestions;
    private boolean showResults;
    private Set<QuestionDto> questions;
    private Set<UserResult> userResults;
    private Theme theme;
    private Set<User> userFavorite;
    private User linkCreator;
}