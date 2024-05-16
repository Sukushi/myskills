package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.UserResult;
import lombok.*;
import lombok.experimental.Accessors;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserAnswersDto extends BaseEntityDto {
    private String text;
    private boolean correct;
    private ImageDto img;
    private QuestionDto question;
    private UserResult userResult;
    private CoordinatesDto coordinates;
}