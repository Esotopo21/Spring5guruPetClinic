package it.burlac.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Pet extends BaseEntity {

    private String name;
    @Column(name = "birth_date")
    private Date birthData;
    @ManyToOne
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthData() {
        return birthData;
    }

    public void setBirthData(Date birthData) {
        this.birthData = birthData;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", birthData=" + birthData +
                ", petType=" + petType +
                ", owner=" + owner.getLastName() +
                '}';
    }
}
