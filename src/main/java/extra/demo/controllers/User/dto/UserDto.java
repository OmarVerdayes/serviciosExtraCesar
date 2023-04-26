package extra.demo.controllers.User.dto;

import extra.demo.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private String email;
    private String name;
    private String password;
    private String photo;

    public User castToUser(){
        return new User(getEmail(),getName(),getPassword(),getPhoto());
    }
}
