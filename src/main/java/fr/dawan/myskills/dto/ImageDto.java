package fr.dawan.myskills.dto;

import lombok.*;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ImageDto extends BaseEntityDto {
    private String source;
    private String originalFileName;
    private String mimeType;
}