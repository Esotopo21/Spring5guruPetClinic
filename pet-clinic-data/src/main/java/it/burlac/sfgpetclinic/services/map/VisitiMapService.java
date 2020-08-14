package it.burlac.sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Visit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.services.VisitiService;

import java.util.Set;

@Service
@Profile("mapservices")
public class VisitiMapService extends AbstractMapService<Visit, Long> implements VisitiService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                        || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
