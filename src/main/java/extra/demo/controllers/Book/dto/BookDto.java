package extra.demo.controllers.Book.dto;


import extra.demo.models.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private Long pages;
    private Long year;

    public Book castToBook(){
        return new Book(getId(),getName(),getAuthor(),getPages(),getYear());
    }

}
