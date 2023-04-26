package extra.demo.controllers.Carrer;

import extra.demo.controllers.Carrer.dto.CarrerDto;
import extra.demo.models.carrer.Carrer;
import extra.demo.models.utils.CustomResponse;
import extra.demo.services.CarrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/career")
@CrossOrigin(origins = {"*"})
public class CarrerController {
    @Autowired
    CarrerService carrerService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Carrer>>> getAll(){
        return new ResponseEntity<>(this.carrerService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Carrer>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.carrerService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Carrer>> insert(@Valid @RequestBody CarrerDto carrer){
        return new ResponseEntity<>(this.carrerService.insert(carrer.casToCarre()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Carrer>> update(@Valid @RequestBody CarrerDto carrer){
        return new ResponseEntity<>(this.carrerService.update(carrer.casToCarre()),HttpStatus.CREATED);
    }
    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Carrer>> delete(@Valid @RequestBody CarrerDto carrer){
        return new ResponseEntity<>(this.carrerService.delete(carrer.casToCarre()),HttpStatus.CREATED);
    }

}
