package no.experisacademy.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "classes")
public class characterClass implements Serializable {

    @Id
    @Column(name = "ClassID", unique = true)
    private int classId;

    @Column(name = "ClassType")
    private String classType;

    @Column(name = "Ability1")
    private String ability1;

    @Column(name = "Ability2")
    private String ability2;

    @Column(name = "Ability3")
    private String ability3;

    public characterClass() {
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public String getAbility3() {
        return ability3;
    }

    public void setAbility3(String ability3) {
        this.ability3 = ability3;
    }
}
