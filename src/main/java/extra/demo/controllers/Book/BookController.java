package extra.demo.controllers.Book;


import extra.demo.controllers.Book.dto.BookDto;
import extra.demo.controllers.Carrer.dto.CarrerDto;
import extra.demo.models.book.Book;
import extra.demo.models.carrer.Carrer;
import extra.demo.models.utils.CustomResponse;
import extra.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = {"*"})
public class BookController {
    @Autowired
    BookService service;
    
    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Book>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Book>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.service.getOne(id),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Book>> insert(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(this.service.insert(bookDto.castToBook()),HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<CustomResponse<Book>> update(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(this.service.update(bookDto.castToBook()),HttpStatus.CREATED);
    }
    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Book>> delete(@Valid @RequestBody BookDto bookDto){
        return new ResponseEntity<>(this.service.delete(bookDto.castToBook()),HttpStatus.CREATED);
    }

}
