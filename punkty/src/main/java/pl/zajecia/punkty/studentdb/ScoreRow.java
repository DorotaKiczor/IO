package pl.zajecia.punkty.studentdb;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ScoreRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int score;

    public int getScore() {
        return score;
    }

    private String comment;
    @ManyToOne
    private StudentRow student;
    @OneToMany(mappedBy = "student")
    private Set<ScoreRow> scores;
    @OneToMany(mappedBy = "student")
    private Set<ScoreRow> scores;

    public ScoreRow(int score, String comment, StudentRow student) {
        this.score = score;
        this.comment = comment;
        this.student = student;}
    protected ScoreRow() {}
}
