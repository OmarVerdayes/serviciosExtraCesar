package extra.demo.services;

import extra.demo.controllers.Carrer.dto.CarrerDto;
import extra.demo.models.carrer.Carrer;
import extra.demo.models.carrer.CarrerRepository;
import extra.demo.models.subject.Subject;
import extra.demo.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
public class CarrerService {
    @Autowired
    CarrerRepository repository;
    @Transactional(readOnly=true)
    public CustomResponse<List<Carrer>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),false,200, "OK"
        );
    }
    @Transactional(readOnly = true)
    public CustomResponse<Carrer> getOne(Long id){
        return new CustomResponse<>(this.repository.findById(id).get(),false,200,"OK");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Carrer> insert(@Valid Carrer career){
        return new CustomResponse<>(this.repository.saveAndFlush(career), false,200,"Carrera registrada!");
    }
    @Transactional(rollbackFor =SQLException.class )
    public CustomResponse<Carrer> update(Carrer career){
        if(!this.repository.existsById(career.getId()))
            return new CustomResponse<>(null,true,400,"La carrera no existe");

        return new CustomResponse<>(this.repository.saveAndFlush(career),false,200,"Carrera actualizada");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Carrer> delete(Carrer carrer){
        if(!this.repository.existsById(carrer.getId()))
            return new CustomResponse<>(null,true,400,"Materia no existe");

        this.repository.deleteById(carrer.getId());

        return new CustomResponse<>(null,false,200,"Materia eliminada coreectamente");
    }
}
