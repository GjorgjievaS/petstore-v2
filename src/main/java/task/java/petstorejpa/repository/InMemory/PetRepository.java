package task.java.petstorejpa.repository.InMemory;


import task.java.petstorejpa.model.Pet;

import java.util.List;
import java.util.Optional;


public interface PetRepository {
    int insertPet(Pet pet);

    List<Pet> selectAllPets();

    Optional<Pet> selectPetById(Long id);

    int deletePetById(Long id);

    int updatePetById(Long id, Pet pet);

}
