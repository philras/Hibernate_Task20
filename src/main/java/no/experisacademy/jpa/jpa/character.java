package no.experisacademy.jpa.jpa;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class character {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Level")
    private int level;

    @Column(name = "ClassID")
    private int classID;

    public character() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }
}
