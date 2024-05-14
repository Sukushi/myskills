package fr.dawan.myskills.dto;

import fr.dawan.myskills.entities.UserResult;
import lombok.*;

import java.io.Serializable;


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