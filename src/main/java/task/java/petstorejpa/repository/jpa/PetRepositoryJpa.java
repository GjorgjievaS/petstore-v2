package task.java.petstorejpa.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.java.petstorejpa.model.Pet;

import java.util.List;

@Repository
public interface PetRepositoryJpa extends JpaRepository<Pet, Long> {
    List<Pet> findPetById(Long id);
    void deletePetById(Long id);
    List<Pet> findAll();
}
