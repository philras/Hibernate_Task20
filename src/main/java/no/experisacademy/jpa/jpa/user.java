package no.experisacademy.jpa.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class user implements Serializable {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name = "id")
    private List<character> characters;

    public List<character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<character> characters) {
        this.characters = characters;
    }

    public user() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + "\t" + user_name + "\t" + email + "\t" + password;
    }
}
