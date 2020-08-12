package sfgpetclinic.services.map;

import it.burlac.sfgpetclinic.model.Speciality;
import it.burlac.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;
import sfgpetclinic.services.SpecialityService;
import sfgpetclinic.services.VetService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if(vet != null){
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
