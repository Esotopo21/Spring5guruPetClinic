package it.burlac.sfgpetclinic.model.services.map;

import it.burlac.sfgpetclinic.model.Vet;
import it.burlac.sfgpetclinic.model.services.VetService;

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
        return this.findAll();
    }

    @Override
    public void delete(Vet vet) {
        this.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return this.save(vet.getId(),vet);
    }

    @Override
    public void deleteById(Long id) {
        this.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return this.findById(id);
    }
}
