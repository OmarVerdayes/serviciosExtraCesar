package extra.demo.controllers.Subject.dto;

import extra.demo.models.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubjectDto {
    private Long id;
    private String acronim;
    private String name;
    public Subject casToSubject(){
        return new Subject(getId(),getAcronim(),getName());
    }
}
