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
public class UserLoginDto {
    private String email;
    private String password;


    public User castToLogin(){
        return new User(getEmail(),null,getPassword(),null);
    }
}
