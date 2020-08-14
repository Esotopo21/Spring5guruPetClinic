package it.burlac.sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Owner;
import it.burlac.sfgpetclinic.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.services.OwnerService;
import it.burlac.sfgpetclinic.services.PetService;
import it.burlac.sfgpetclinic.services.PetTypeService;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@Profile("mapservices")
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return super.map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).collect(Collectors.toSet());
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null){
            if (owner.getPets() != null){
                owner.getPets().forEach(pet -> {
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
        }

        return super.save(owner);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
