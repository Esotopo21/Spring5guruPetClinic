package sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Pet;
import it.burlac.sfgpetclinic.model.PetType;
import org.springframework.stereotype.Service;
import sfgpetclinic.services.PetService;
import sfgpetclinic.services.PetTypeService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    private final PetTypeService petTypeService;

    public PetMapService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

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
        if(pet != null){
            if (pet.getPetType() != null){
                if (pet.getPetType().getId() == null){
                    PetType savedPetType = petTypeService.save(pet.getPetType());
                    pet.getPetType().setId(savedPetType.getId());
                }
            }else{
                throw new RuntimeException("Pet type is required");
            }
        }
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
