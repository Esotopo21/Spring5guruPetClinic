package it.burlac.sfgpetclinic.services;

import it.burlac.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Set<Owner> findByLastName(String lastName);

}
