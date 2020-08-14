package it.burlac.sfgpetclinic.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(value = {CascadeType.ALL})
    @JoinTable(joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
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
