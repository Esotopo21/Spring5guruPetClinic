package it.burlac.sfgpetclinic.services;

import it.burlac.sfgpetclinic.model.Vet;

import java.util.List;

public interface VetService extends CrudService<Vet, Long>{

    List<Vet> findBytName(String name);

}
