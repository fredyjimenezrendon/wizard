package io.indorse.test.authentication.dao.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private int id;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "id_rol")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
