package io.indorse.test.authentication.dao.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_rol")
public class UserRol implements Serializable {

    private int id;
    private User user;
    private Rol rol;

    @Id
    @GeneratedValue
    @Column(name = "id_user_rol")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
