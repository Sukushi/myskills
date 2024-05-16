package fr.dawan.myskills.dtos;

import fr.dawan.myskills.entities.Category;
import fr.dawan.myskills.entities.Theme;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseEntityDto implements AliasableDto {
    private String name;
	private String alias;
    private String description;
    private boolean visible;
    private Set<Theme> themes;
    private Category categoryParent;
}