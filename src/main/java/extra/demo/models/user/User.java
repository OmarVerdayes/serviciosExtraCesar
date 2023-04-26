package extra.demo.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;



@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String email;
    @Column()
    private String name;
    @Column (nullable = false)
    private String password;
    @Column()
    @Lob
    private String photo;
}
