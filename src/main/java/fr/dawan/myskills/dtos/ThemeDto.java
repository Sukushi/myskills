package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.Theme;
import lombok.*;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ThemeDto extends BaseEntityDto implements AliasableDto {
    private String name;
	private String alias;
    private String description;
    private String icon;
    private Theme themeParent;
    private Set<CategoryDto> categories;
    private Set<QuizDto> quizzes;
    private Set<QuestionDto> questions;
}