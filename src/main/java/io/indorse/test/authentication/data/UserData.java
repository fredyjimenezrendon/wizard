package io.indorse.test.authentication.data;

import javax.validation.constraints.*;

public class UserData {

    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=2, max=30)
    private String lastName;
    @NotNull
    @Email
    @Size(min=6, max=30)
    private String mail;
    @NotNull
    @Size(min=64, max=128)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
