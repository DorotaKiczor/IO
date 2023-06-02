package studentdb;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class StudentRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     private String name;
    private String number;
    private String group;

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
}
