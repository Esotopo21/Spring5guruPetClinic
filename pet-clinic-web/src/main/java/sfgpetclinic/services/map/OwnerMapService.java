package sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Owner;
import sfgpetclinic.services.OwnerService;

import java.util.Set;
import java.util.stream.Collectors;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findByLastName(String lastName) {
        return super.map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).collect(Collectors.toSet());
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(),owner);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
