package it.burlac.sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.services.SpecialtyService;

import java.util.Set;

@Service
@Profile("mapservices")
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {


    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
