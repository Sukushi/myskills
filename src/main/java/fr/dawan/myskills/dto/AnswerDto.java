package fr.dawan.myskills.dto;

import fr.dawan.myskills.entities.Coordinates;
import fr.dawan.myskills.entities.Image;
import fr.dawan.myskills.entities.Question;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnswerDto extends BaseEntityDto {
    private String text;
    private boolean correct;
    private Image img;
    private Question question;
    private List<Coordinates> coordinates;
}
