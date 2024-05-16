package fr.dawan.myskills.dtos;

import lombok.*;
import lombok.experimental.Accessors;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto extends BaseEntityDto {
    private String source;
    private String originalFileName;
    private String mimeType;
}