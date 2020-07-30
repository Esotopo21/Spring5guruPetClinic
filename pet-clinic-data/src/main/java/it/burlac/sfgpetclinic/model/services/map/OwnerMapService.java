package it.burlac.sfgpetclinic.model.services.map;

import it.burlac.sfgpetclinic.model.Owner;
import it.burlac.sfgpetclinic.model.services.OwnerService;

import java.util.Set;
import java.util.stream.Collectors;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return this.map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).collect(Collectors.toSet());
    }

    @Override
    public Set<Owner> findAll() {
        return this.findAll();
    }

    @Override
    public void delete(Owner owner) {
        this.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        return this.save(owner.getId(),owner);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Owner findById(Long id) {
        return this.findById(id);
    }
}
