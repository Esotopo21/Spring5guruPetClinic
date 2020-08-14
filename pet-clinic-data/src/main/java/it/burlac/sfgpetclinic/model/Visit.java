package it.burlac.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    @OneToOne
    private Pet pet;

    public Visit() {
    }

    public Visit(long id) {
        super(id);
    }

    public Visit(LocalDate date, String description, Pet pet) {
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    public Visit(long id, LocalDate date, String description, Pet pet) {
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

}
