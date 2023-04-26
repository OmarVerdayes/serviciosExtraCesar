package extra.demo.controllers.Student;

import extra.demo.controllers.Student.dto.StudentDto;
import extra.demo.models.student.Student;
import extra.demo.models.utils.CustomResponse;
import extra.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins =  {"*"})
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Student>>> getAll(){
        return new ResponseEntity<>(this.studentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Student>> getOne(@PathVariable("id")String id){
        return  new ResponseEntity<>(this.studentService.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Student>>insert(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(this.studentService.insert(studentDto.casToStudent()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Student>>update(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(this.studentService.update(studentDto.casToStudent()),HttpStatus.CREATED);
    }
    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Student>>delete(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(this.studentService.delete(studentDto.casToStudent()),HttpStatus.CREATED);
    }
}
