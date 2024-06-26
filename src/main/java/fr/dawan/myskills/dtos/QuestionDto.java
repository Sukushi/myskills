package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.Quiz;
import fr.dawan.myskills.entities.Theme;
import fr.dawan.myskills.entities.UserAnswers;
import fr.dawan.myskills.entities.enums.LevelEnum;
import fr.dawan.myskills.entities.enums.QuestionStatusEnum;
import fr.dawan.myskills.entities.enums.QuestionTypeEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto extends BaseEntityDto {
    private String text;
    private ImageDto img;
    private QuestionStatusEnum status;
    private QuestionTypeEnum type;
    private LevelEnum level;
    private String qstKeywords;
    private String explanation;
    private LocalDateTime creationDate;
    private int time;
    private List<AnswerDto> answers;
    private List<UserAnswers> userAnswers;
    private Set<Quiz> quizzes;
    private Set<Theme> themes;
}