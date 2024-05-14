package fr.dawan.myskills.dto;

import fr.dawan.myskills.entities.Category;
import fr.dawan.myskills.entities.Theme;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryDto extends BaseEntityDto {
    private String name;
    private String description;
    private boolean visible;
    private Set<Theme> themes;
    private Category categoryParent;
}