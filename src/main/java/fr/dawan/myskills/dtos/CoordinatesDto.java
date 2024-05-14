package fr.dawan.myskills.dtos;

import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CoordinatesDto extends BaseEntityDto {
    private int x;
    private int y;
    private AnswerDto answer;
}