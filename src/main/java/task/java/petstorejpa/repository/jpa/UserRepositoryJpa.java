package task.java.petstorejpa.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.java.petstorejpa.model.User;

import java.util.List;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {
    List<User> findUserById(Long id);
    void deleteUserById(Long id);
    List<User> findAll();
}
