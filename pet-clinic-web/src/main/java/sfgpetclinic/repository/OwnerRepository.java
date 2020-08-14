package sfgpetclinic.repository;

import it.burlac.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Iterable<Owner> findByLastName(String lastName);
}
