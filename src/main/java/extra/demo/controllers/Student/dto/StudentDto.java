package extra.demo.controllers.Student.dto;

import extra.demo.models.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentDto {
    private String id;
    private String name;
    private String lastname;
    private long years;
    private String direccion;

    public Student casToStudent(){
        return new Student(getId(),getName(),getLastname(),getYears(),getDireccion());
    }

}
