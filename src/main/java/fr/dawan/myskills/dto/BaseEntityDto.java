package fr.dawan.myskills.dto;

import lombok.Data;

@Data
public abstract class BaseEntityDto {
    protected long id;
    protected int version;

}
