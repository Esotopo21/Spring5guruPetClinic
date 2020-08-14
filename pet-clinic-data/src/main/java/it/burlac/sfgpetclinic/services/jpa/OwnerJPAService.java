package it.burlac.sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.Owner;
import it.burlac.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.repository.OwnerRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default","jpaservices"})
public class OwnerJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findByLastName(String lastName) {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findByLastName(lastName).iterator().forEachRemaining(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findAll().iterator().forEachRemaining(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).get();
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
