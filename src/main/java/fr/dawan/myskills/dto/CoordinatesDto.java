package fr.dawan.myskills.dto;

import lombok.*;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CoordinatesDto extends BaseEntityDto {
    private int x;
    private int y;
    private AnswerDto answer;
}