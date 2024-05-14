package fr.dawan.myskills.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AliasableDto extends BaseEntityDto {
	protected String alias;
}
