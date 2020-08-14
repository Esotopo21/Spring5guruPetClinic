package it.burlac.sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.PetType;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.services.PetTypeService;

import java.util.Set;

@Service
@Profile("mapservices")
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {


    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

    @Override
    public void deleteById(Long aLong) {
        this.map.remove(aLong);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
