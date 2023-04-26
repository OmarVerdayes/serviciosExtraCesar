package extra.demo.controllers.Subject;

import extra.demo.controllers.Carrer.dto.CarrerDto;
import extra.demo.controllers.Subject.dto.SubjectDto;
import extra.demo.models.carrer.Carrer;
import extra.demo.models.subject.Subject;
import extra.demo.models.utils.CustomResponse;
import extra.demo.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/subject")
@CrossOrigin(origins =  {"*"})
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Subject>>> getAll(){
        return new ResponseEntity<>(this.subjectService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Subject>> insert(@Valid @RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(this.subjectService.insert(subjectDto.casToSubject()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Subject>> update(@Valid @RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(this.subjectService.update(subjectDto.casToSubject()),HttpStatus.CREATED);
    }
    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Subject>> delete(@Valid @RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(this.subjectService.delete(subjectDto.casToSubject()),HttpStatus.CREATED);
    }
}
