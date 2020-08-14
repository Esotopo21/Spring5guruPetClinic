package sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.Vet;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sfgpetclinic.repository.VetRepository;
import sfgpetclinic.services.VetService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Primary
public class VetJPAService implements VetService {

    private final VetRepository vetRepository;

    public VetJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public List<Vet> findBytName(String name) {
        List<Vet> vets = new ArrayList<>();
        vetRepository.findByFirstName(name).iterator().forEachRemaining(vets::add);
        return vets;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().iterator().forEachRemaining(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).get();
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
