package it.burlac.sfgpetclinic.model.services;

import it.burlac.sfgpetclinic.model.Pet;

import java.util.List;

public interface PetService {

    Pet findById(long id);

    List<Pet> findBytName(String name);

    Pet save(Pet pet);

    List<Pet> findAll();

    Pet delete(Pet pet);
}
