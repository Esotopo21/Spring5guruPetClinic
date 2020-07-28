package it.burlac.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private static final long UUID = 232423525245l;

    private long id;

    public BaseEntity() {
    }

    public BaseEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
