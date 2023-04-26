package extra.demo.controllers.email;

import extra.demo.controllers.email.dtos.EmailDto;
import extra.demo.models.utils.CustomResponse;
import extra.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = {"*"})
public class EmailController {
    @Autowired
    private EmailService service;
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Object>> sendMail(
            @Valid @RequestBody EmailDto email
    ){
        return new ResponseEntity<>(
                new CustomResponse<>(
                        null,
                        this.service.sendMail(email),
                        200,
                        "OK"),
                HttpStatus.OK
        );
    }
}
