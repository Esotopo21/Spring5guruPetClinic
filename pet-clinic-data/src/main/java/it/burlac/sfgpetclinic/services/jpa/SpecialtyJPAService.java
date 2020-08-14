package it.burlac.sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.repository.SpecilityRepository;
import it.burlac.sfgpetclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default","jpaservices"})
public class SpecialtyJPAService implements SpecialtyService {

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
