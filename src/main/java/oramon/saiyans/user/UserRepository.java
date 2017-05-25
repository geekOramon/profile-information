package oramon.saiyans.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u where u.email = :email")
    User getUserByEmail(@Param(value = "email") String email);
}
