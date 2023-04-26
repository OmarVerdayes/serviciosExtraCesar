package extra.demo.services;

import extra.demo.models.book.Book;
import extra.demo.models.book.BookRepository;
import extra.demo.models.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repository;
    @Transactional(readOnly=true)
    public CustomResponse<List<Book>> getAll(){
        return new CustomResponse<>(this.repository.findAll(),false,200, "OK");
    }
    @Transactional(readOnly = true)
    public CustomResponse<Book> getOne(Long id){
        return new CustomResponse<>(this.repository.findById(id).get(),false,200,"OK");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Book> insert(@Valid Book book){

        return new CustomResponse<>(this.repository.saveAndFlush(book), false,200,"Libro registrada!");
    }
    @Transactional(rollbackFor =SQLException.class )
    public CustomResponse<Book> update(Book book){
        if(!this.repository.existsById(book.getId()))
            return new CustomResponse<>(null,true,400,"El libro no existe");

        return new CustomResponse<>(this.repository.saveAndFlush(book),false,200,"Libro actualizada");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Book> delete(Book book){
        if(!this.repository.existsById(book.getId()))
            return new CustomResponse<>(null,true,400,"Libro no existe");

        this.repository.deleteById(book.getId());

        return new CustomResponse<>(null,false,200,"Libro eliminada coreectamente");
    }
}
