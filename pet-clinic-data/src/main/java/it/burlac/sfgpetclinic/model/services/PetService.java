package it.burlac.sfgpetclinic.model.services;

import it.burlac.sfgpetclinic.model.Pet;

import java.util.List;
import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{

    Set<Pet> findBytName(String name);

}
