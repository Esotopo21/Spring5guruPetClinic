package sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.PetType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sfgpetclinic.repository.PetTypeRepository;
import sfgpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
public class PetTypeJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> types = new HashSet<>();
        petTypeRepository.findAll().iterator().forEachRemaining(types::add);
        return types;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).get();
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
