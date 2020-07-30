package sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Vet;
import sfgpetclinic.services.VetService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VerMapService extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public List<Vet> findBytName(String name) {
        return this.map.values().stream().filter(vet -> vet.getFirstName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(),vet);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}