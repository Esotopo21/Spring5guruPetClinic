package it.burlac.sfgpetclinic.services;

import it.burlac.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{

    Set<Pet> findBytName(String name);

}
