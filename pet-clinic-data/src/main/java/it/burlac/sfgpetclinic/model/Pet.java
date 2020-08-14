package it.burlac.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Pet extends BaseEntity {

    private String name;
    @Column(name = "birth_date")
    private Date birthData;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private PetType petType;
    @ManyToOne
    private Owner owner;

    public Pet() {
    }

    public Pet(String name, Date birthData, PetType petType, Owner owner) {
        this.name = name;
        this.birthData = birthData;
        this.petType = petType;
        this.owner = owner;
    }

    public Pet(long id, String name, Date birthData, PetType petType, Owner owner) {
        super(id);
        this.name = name;
        this.birthData = birthData;
        this.petType = petType;
        this.owner = owner;
    }

}
