package extra.demo.models.carrer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "careers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Carrer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String acronim;
    private String name;
}
