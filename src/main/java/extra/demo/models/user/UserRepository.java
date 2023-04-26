package extra.demo.models.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    User findByEmailAndPassword(String email,String password);

    boolean existsByEmailAndPassword(String email, String password);
}
