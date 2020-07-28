package it.burlac.sfgpetclinic.model.services;

import it.burlac.sfgpetclinic.model.Vet;

import java.util.List;

public interface VetService {

    Vet findById(long id);

    List<Vet> findBytName(String name);

    Vet save(Vet vet);

    List<Vet> findAll();

    Vet delete(Vet vet);

}
