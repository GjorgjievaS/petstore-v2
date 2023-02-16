package task.java.petstorejpa.repository.InMemory;

import org.springframework.stereotype.Repository;
import task.java.petstorejpa.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("userRepo")
public class UserRepositoryImpl implements UserRepository{

    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(User user) {
        if (DB.size() == 10) return 0;
        DB.add(new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getBudget()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(Long id) {
        Optional<User> userMaybe = selectUserById(id);
        if (userMaybe.isEmpty()) return 0;
        DB.remove(userMaybe.get());
        return 1;
    }

    @Override
    public int updateUserById(Long id, User update) {
        return selectUserById(id)
                .map(user -> {
                    int indexOfUserToUpdate = DB.indexOf(user);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(update.getFirstName(),update.getLastName(),update.getEmail(),update.getBudget()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
