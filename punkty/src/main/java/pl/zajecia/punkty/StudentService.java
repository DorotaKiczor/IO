package pl.zajecia.punkty;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajecia.punkty.studentdb.ScoreRow;
import pl.zajecia.punkty.studentdb.StudentRepozytory;
import pl.zajecia.punkty.studentdb.StudentRow;

import java.util.Optional;

@Service
public class StudentService {
    //private List<Student> students = List.empty();
    private final StudentRepozytory repozytory;
    private final ScoreRepository scoreRepository;
    public StudentService(StudentRepozytory repozytory, ScoreRepository scoreRepository) {
        this.repozytory = repozytory;
        this.scoreRepository = scoreRepository;
    }

    //    List<Student> getStudents() {
//        //throw new UnsupportedOperationException();
//        //return students;
//        return List.offAll(this.repozytory.findAll()).map(Function());
//
//    }
List<Student> getStudents() {
    return List.ofAll(this.repozytory.findAll())
            .map(StudentRow::toStudent);
    }

    Student addStudent(final NewStudent newStudent) {
        return this.repozytory.save(new StudentRow(
                newStudent.name,
                newStudent.number,
                newStudent.group)).toStudent();
    }
    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentRow> student = this.repozytory.findById(studentId);
        return student.map(c -> {
            c.setNumber(newNumber);
            repozytory.save(c);
            return c.toStudent();
        });
    }
    @Transactional
    public Optional<Integer> addScore(final long studentId, final Score score) {
        final Optional<StudentRow> student =
                this.repozytory.findById(studentId);
        return student.map(c->{
            int existingScore=List.ofAll(c.getScores())
                    .foldLeft(0,(p,s)->p+s.getScore());
            final ScoreRow newScore=new ScoreRow(score.score,score.comment,c);
            this.scoreRepository.save(newScore);
            return existingScore+score.score;});}
        });
    }
//    private static Function<StudentRow, Student> getStudentRowStudentFunction() {
//        return dbObj ->
//                new Student(
//                        dbObj.getId(),
//                        dbObj.getName(),
//                        dbObj.getNumber(),
//                        dbObj.getGroup());
//    }

    //    void addStudent(final Student newStudent){
//        throw new UnsupportedOperationException();
//    }
//    Student addStudent(final NewStudent newStudent){
//        //throw new UnsupportedOperationException();
//        StudentRow created = this.repozytory.save(new StudentRow(
//                newStudent.name,
//                newStudent.number,
//                newStudent.group);
//        return getStudentRowStudentFunction().apply(created);
//    }

    //Student addStudent(final NewStudent newStudent) {
        //Student created = new Student(1, "aa", "aa", "aa");
        //Student created = new Student(1, newStudent.name, newStudent.number, newStudent.group);
        //Student created = new Student(students.size() + 1, newStudent.name, newStudent.number, newStudent.group);
        //students = students.prepend(created);
        //return created;
    //}
}
