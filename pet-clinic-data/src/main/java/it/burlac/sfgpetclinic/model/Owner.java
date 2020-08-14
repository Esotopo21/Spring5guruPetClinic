package it.burlac.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();

}
