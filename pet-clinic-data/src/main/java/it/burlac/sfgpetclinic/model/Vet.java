package it.burlac.sfgpetclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person {

    @OneToMany
    private Set<Speciality> specialities = new HashSet<>();

    public Vet() {
    }

    public Vet(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Vet(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Vet(long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    public Vet(String firstName, String lastName, Set<Speciality> specialities) {
        super(firstName, lastName);
        this.specialities = specialities;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
