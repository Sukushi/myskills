package fr.dawan.myskills.dtos;

import lombok.Data;

@Data
public abstract class BaseEntityDto {
    protected long id;
    protected int version;

}
