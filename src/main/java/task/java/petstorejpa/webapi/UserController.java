package task.java.petstorejpa.webapi;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.java.petstorejpa.model.User;
import task.java.petstorejpa.service.UserService;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public void addUser(@NonNull @RequestBody User user) {
        this.userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")                      //@Valid   ne e tocna izgl funkcijava
    public void updateUser(@PathVariable Long id,  @NonNull @RequestBody User user) {
        this.userService.addUser(user);
    }

    @PostMapping(path = "/create-all/{numUsers}")
    public void createUsers(@PathVariable int numUsers) throws IOException, InterruptedException {
        this.userService.createUsers(numUsers);
    }
}
