package it.burlac.sfgpetclinic.services.jpa;

import it.burlac.sfgpetclinic.model.Visit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import it.burlac.sfgpetclinic.repository.VisitRepository;
import it.burlac.sfgpetclinic.services.VisitiService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default","jpaservices"})
public class VisitJpaService implements VisitiService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
