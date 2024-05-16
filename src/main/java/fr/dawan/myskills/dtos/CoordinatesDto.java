package fr.dawan.myskills.dtos;

import lombok.*;
import lombok.experimental.Accessors;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesDto extends BaseEntityDto {
    private int x;
    private int y;
    private AnswerDto answer;
}