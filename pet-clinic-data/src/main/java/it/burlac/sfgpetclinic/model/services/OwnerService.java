package it.burlac.sfgpetclinic.model.services;

import it.burlac.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner findById(long id);

    List<Owner> findByLastName(String lastName);

    Owner save(Owner owner);

    List<Owner> findAll();

    Owner delete(Owner owner);


}
