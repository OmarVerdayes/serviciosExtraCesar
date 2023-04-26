package extra.demo.controllers.email.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmailDto {
    private String email;
    private String asunto;
    private String cuerpo;
}
