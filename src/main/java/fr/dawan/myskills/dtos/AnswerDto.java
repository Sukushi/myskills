package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.Coordinates;
import fr.dawan.myskills.entities.Image;
import fr.dawan.myskills.entities.Question;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto extends BaseEntityDto {
    private String text;
    private boolean correct;
    private Image img;
    private Question question;
    private List<Coordinates> coordinates;
}
