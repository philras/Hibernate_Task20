package no.experisacademy.jpa;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class character {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Level")
    private int level;

    @Column(name = "FKclassID")
    private int FKid;

    @OneToOne
    @JoinColumn(name = "FKclassID", insertable = false, updatable = false)
    private characterClass characterClass;

    public no.experisacademy.jpa.characterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(no.experisacademy.jpa.characterClass characterClass) {
        this.characterClass = characterClass;
    }

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

    public int getFKclassID() {
        return FKid;
    }

    public void setFKclassID(int FKclassID) {
        this.FKid = FKclassID;
    }
}
