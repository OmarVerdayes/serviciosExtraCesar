package extra.demo.models.carrer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrerRepository extends JpaRepository<Carrer, Long> {
}
