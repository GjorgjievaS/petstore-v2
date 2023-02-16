package task.java.petstorejpa.repository.InMemory;


import task.java.petstorejpa.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {

    int insertUser(User user);

    List<User> selectAllUsers();
    
    Optional<User> selectUserById(Long id);
    
    int deleteUserById(Long id);
    
    int updateUserById(Long id, User user);
}
