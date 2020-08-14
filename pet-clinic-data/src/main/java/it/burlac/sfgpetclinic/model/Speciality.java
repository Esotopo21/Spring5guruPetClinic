package it.burlac.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import java.util.Objects;

@Data
@Entity
public class Speciality extends BaseEntity {

    private String description;

    public Speciality() {
    }

    public Speciality(long id) {
        super(id);
    }

    public Speciality(String description) {
        this.description = description;
    }

    public Speciality(long id, String description) {
        super(id);
        this.description = description;
    }

}
