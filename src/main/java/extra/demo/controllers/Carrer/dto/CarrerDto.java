package extra.demo.controllers.Carrer.dto;

import extra.demo.models.carrer.Carrer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CarrerDto {
    private Long id;
    private String name;
    private String acronim;

    public Carrer casToCarre(){
        return new Carrer(getId(),getAcronim(),getName());
    }
}
