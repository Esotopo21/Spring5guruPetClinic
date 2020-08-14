package sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.Speciality;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sfgpetclinic.repository.SpecilityRepository;
import sfgpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
public class SpecialtyJPAService implements SpecialityService {

    private final SpecilityRepository specilityRepository;

    public SpecialtyJPAService(SpecilityRepository specilityRepository) {
        this.specilityRepository = specilityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specilityRepository.findAll().iterator().forEachRemaining(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specilityRepository.findById(aLong).get();
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specilityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specilityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long aLong) {
        specilityRepository.deleteById(aLong);
    }
}
