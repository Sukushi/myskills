package fr.dawan.myskills.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public abstract class BaseEntityDto {
    protected long id;
    protected int version;

}
