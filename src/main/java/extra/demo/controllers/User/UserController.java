package extra.demo.controllers.User;


import extra.demo.controllers.User.dto.UserDto;
import extra.demo.controllers.User.dto.UserLoginDto;
import extra.demo.models.user.User;
import extra.demo.models.utils.CustomResponse;
import extra.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<User>>> getAll(){
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<User>> insert(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.insert(userDto.castToUser()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<User>>update(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.update(userDto.castToUser()),HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<CustomResponse<User>> login(@Valid @RequestBody UserLoginDto userLoginDto){
        return new ResponseEntity<>(this.userService.login(userLoginDto.castToLogin()),HttpStatus.CREATED);
    }

}
