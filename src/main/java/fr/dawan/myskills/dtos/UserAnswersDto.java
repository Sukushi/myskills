package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.UserResult;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserAnswersDto extends BaseEntityDto {
    private String text;
    private boolean correct;
    private ImageDto img;
    private QuestionDto question;
    private UserResult userResult;
    private CoordinatesDto coordinates;
}