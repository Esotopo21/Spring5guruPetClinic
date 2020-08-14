package it.burlac.sfgpetclinic.repository;

import it.burlac.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Iterable<Owner> findByLastName(String lastName);
}
