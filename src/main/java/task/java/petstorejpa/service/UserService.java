package task.java.petstorejpa.service;


import org.springframework.stereotype.Service;
import task.java.petstorejpa.model.User;
import task.java.petstorejpa.repository.jpa.UserRepositoryJpa;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepositoryJpa userRepository;


    public UserService(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> addUser(User user) {
        this.userRepository.deleteUserById(user.getId());

        return Optional.of(this.userRepository.save(new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getBudget())));
    }

    public int createUsers(int numUsers) throws IOException, InterruptedException {
        if (numUsers < 0) numUsers = 0;
        if (numUsers > 10) numUsers = 10;

        for (int i=0; i<numUsers; i++){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://randomuser.me/api/"))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = null;
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            String firstName = json.split("first")[1].substring(3).split("\"")[0];
            String lastName = json.split("last")[1].substring(3).split("\"")[0];
            String email = json.split("email")[1].substring(3).split("\"")[0];

            float budget = (float) (Math.random() * 50);
            budget = (float) ((int) (budget * 100)) / 100;
            //                   30.12345 * 100 -> 3012.345
            //                 (int)  3012.345  -> 3012
            //                (float) 3012      -> 3012.0
            //                   3012.0  / 100  -> 30.12

            User user = new User(firstName, lastName, email, budget);
            this.userRepository.save(user);
        }
        return 1;
    }

    public List<User> getAllPeople(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return this.userRepository.findUserById(id).stream().findFirst();
    }

    @Transactional
    public void deleteUser(Long id) {
         this.userRepository.deleteUserById(id);
    }
}
