package it.burlac.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

    private String name;
    private LocalDate birthData;
    private PetType petType;
    private Owner owner;

    public Pet() {
    }

    public Pet(String name, LocalDate birthData, PetType petType, Owner owner) {
        this.name = name;
        this.birthData = birthData;
        this.petType = petType;
        this.owner = owner;
    }

    public Pet(long id, String name, LocalDate birthData, PetType petType, Owner owner) {
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

    public LocalDate getBirthData() {
        return birthData;
    }

    public void setBirthData(LocalDate birthData) {
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
}
