package sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;
import sfgpetclinic.services.PetService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findBytName(String name) {
        return this.map.values().stream().filter(pet -> pet.getName().equals(name)).collect(Collectors.toSet());
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
