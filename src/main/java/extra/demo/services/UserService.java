package extra.demo.services;

import extra.demo.models.user.User;
import extra.demo.models.user.UserRepository;
import extra.demo.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service

public class UserService {

    @Autowired
    UserRepository repository;
    @Transactional(readOnly = true)
    public CustomResponse<List<User>> getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200,"Ok");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User>insert(User user){
        if(this.repository.existsByEmail(user.getEmail())) {
            return new CustomResponse<>(null, true, 400, "Error al registrar. El estudiante ya existe");
        }
        return new CustomResponse<>(this.repository.saveAndFlush(user),false,200,"Usurario registrado");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User>update(User user){
        if(!this.repository.existsByEmail(user.getEmail())) {
            return new CustomResponse<>(null, true, 400, "Error al actualizar. El estudiante no existe");
        }
        return new CustomResponse<>(this.repository.saveAndFlush(user),false,200,"Usurario actualizado");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<User>login(User user){
        if(!this.repository.existsByEmailAndPassword(user.getEmail(),user.getPassword())) {
            return new CustomResponse<>(null, true, 400, "Error al iniciar sesion");
        }
        return new CustomResponse<>(this.repository.findByEmailAndPassword(user.getEmail(),user.getPassword()),false,200,"Logeo correcto");
    }

}
