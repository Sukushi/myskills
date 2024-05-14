package fr.dawan.myskills.dtos;

import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ImageDto extends BaseEntityDto {
    private String source;
    private String originalFileName;
    private String mimeType;
}