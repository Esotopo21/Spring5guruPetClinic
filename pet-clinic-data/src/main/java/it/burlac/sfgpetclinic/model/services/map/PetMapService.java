package it.burlac.sfgpetclinic.model.services.map;

import it.burlac.sfgpetclinic.model.Pet;
import it.burlac.sfgpetclinic.model.services.PetService;

import java.util.Set;
import java.util.stream.Collectors;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findBytName(String name) {
        return this.map.values().stream().filter(pet -> pet.getName().equals(name)).collect(Collectors.toSet());
    }

    @Override
    public Set<Pet> findAll() {
        return this.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return this.save(pet.getId(),pet);
    }

    @Override
    public void delete(Pet pet) {
        this.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return this.findById(id);
    }
}
