package it.burlac.sfgpetclinic.model.services;

import it.burlac.sfgpetclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Set<Owner> findByLastName(String lastName);

}
