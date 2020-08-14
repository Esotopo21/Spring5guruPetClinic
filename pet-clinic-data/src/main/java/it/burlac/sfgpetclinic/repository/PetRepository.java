package it.burlac.sfgpetclinic.repository;

import it.burlac.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
    Iterable<Pet> findByName(String name);
}
