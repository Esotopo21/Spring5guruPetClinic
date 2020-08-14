package sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.Pet;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sfgpetclinic.repository.PetRepository;
import sfgpetclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
public class PetJPAService implements PetService {

    private final PetRepository petRepository;

    public PetJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findBytName(String name) {
        Set<Pet> pets = new HashSet<>();
        petRepository.findByName(name).iterator().forEachRemaining(pets::add);
        return pets;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().iterator().forEachRemaining(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).get();
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
