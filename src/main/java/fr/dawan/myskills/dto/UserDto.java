package fr.dawan.myskills.dto;

import fr.dawan.myskills.entities.Authority;
import fr.dawan.myskills.entities.UserResult;
import fr.dawan.myskills.entities.enums.Title;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto extends BaseEntityDto {
    private String username;
    private String email;
    private String password;
    private Title title;
    private String firstName;
    private String lastName;
    private int workExperience;
    private LocalDateTime creationDate;
    private LocalDateTime validationDate;
    private boolean enabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean accountNonExpired;
    private boolean submitter;
    private String authToken;
    private String phone;
    private String role;
    private ImageDto avatar;
    private String socialNetworkAvatarURL;
    private String socialNetworkAuthToken;
    private List<Authority> authorities;
    private List<UserResult> userResult;
    private Set<QuizDto> quizFavorite;
}