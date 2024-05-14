package fr.dawan.myskills.dto;

import fr.dawan.myskills.entities.Theme;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ThemeDto extends BaseEntityDto {
    private String name;
    private String description;
    private String icon;
    private Theme themeParent;
    private Set<CategoryDto> categories;
    private Set<QuizDto> quizzes;
    private Set<QuestionDto> questions;
}