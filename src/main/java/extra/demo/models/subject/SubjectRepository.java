package extra.demo.models.subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,String> {
    boolean existsByName(String name);
    boolean existsById(Long id);


    void deleteById(Long id);
}
