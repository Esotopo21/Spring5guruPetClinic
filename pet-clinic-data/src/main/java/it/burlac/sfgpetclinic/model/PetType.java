package it.burlac.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class PetType extends BaseEntity{

    private String name;

    public PetType(){

    }

    public PetType(String name) {
        this.name = name;
    }

    public PetType(long id, String name) {
        super(id);
        this.name = name;
    }

}
