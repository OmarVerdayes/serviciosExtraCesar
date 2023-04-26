package extra.demo.services;

import extra.demo.models.carrer.Carrer;
import extra.demo.models.subject.Subject;
import extra.demo.models.subject.SubjectRepository;
import extra.demo.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class SubjectService {
    @Autowired
    SubjectRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Subject>> getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200,"Ok");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subject>insert(Subject subject){
        if(this.repository.existsByName(subject.getName())){
            return new CustomResponse<>(null,true,400,"Materia ya registrada");
        }
        return  new CustomResponse<>(this.repository.saveAndFlush(subject),false,200,"Materia registrado coreectamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subject> update(Subject subject){
        if(!this.repository.existsById(subject.getId())) //va a dar error por es String.valueOf
            return new CustomResponse<>(null,true,400,"Materia no existe");
        return new CustomResponse<>(
                this.repository.saveAndFlush(subject),false,200,"Materia actualizada coreectamente"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subject> delete(Subject subject){
        if(!this.repository.existsById(subject.getId()))
            return new CustomResponse<>(null,true,400,"Materia no existe");

        this.repository.deleteById(subject.getId());

        return new CustomResponse<>(null,false,200,"Materia eliminada coreectamente");
    }


}
