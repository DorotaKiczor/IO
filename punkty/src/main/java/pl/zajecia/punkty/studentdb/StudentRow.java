package pl.zajecia.punkty.studentdb;

import pl.zajecia.punkty.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class StudentRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     private String name;
    private String number;
    private String group;

    public StudentRow(String name, String number, String group) {
        //this.id = id;
        this.name = name;
        this.number = number;
        this.group = group;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public String getGroup() {
        return group;
    }

    public Student toStudent(){
        return new Student(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getGroup());
    }

    public boolean getScores() {
    }
}
