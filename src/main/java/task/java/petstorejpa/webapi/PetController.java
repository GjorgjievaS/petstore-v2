package task.java.petstorejpa.webapi;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.java.petstorejpa.model.Pet;
import task.java.petstorejpa.service.PetService;

import java.io.IOException;
import java.util.List;


@RequestMapping("/api/pets")
@RestController
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping //@Valid
    public void addPet(@NonNull @RequestBody Pet pet){
        petService.addPet(pet);
    }

    @GetMapping
    public List<Pet> getAllPets(){
        return  petService.getAllPets();
    }

    @GetMapping(path = "{id}")
    public Pet getPetById(@PathVariable Long id){
        return petService.getPetById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePetById(@PathVariable Long id){
        petService.deletePet(id);
    }

    @PutMapping(path = "{id}")                      //,@Valid
    public  void updatePet(@PathVariable Long id, @NonNull @RequestBody Pet pet){
        petService.addPet(pet);
    }

    @PostMapping(path = "/create-all/{numPets}")
    public void createPets(@PathVariable int numPets) throws IOException, InterruptedException {
        petService.createPets(numPets);
    }
}
