package fr.dawan.myskills.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResultDto extends BaseEntityDto {
    private QuizDto quiz;
    private UserDto user;
    private double score;
    private LocalDateTime date;
    private boolean valid;
    private int total;
    private String username;
    private List<UserAnswersDto> userAnswers;
}