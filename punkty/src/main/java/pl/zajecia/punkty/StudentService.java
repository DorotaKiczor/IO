package pl.zajecia.punkty;

import io.vavr.collection.List;
import jdk.nashorn.internal.objects.annotations.Function;
import studentdb.StudentRepozytory;
import studentdb.StudentRow;

import static org.junit.Assert.assertNotNull;

@Service
public class StudentService {
    //private List<Student> students = List.empty();
    private final StudentRepozytory repozytory;

    public StudentService(StudentRepozytory repozytory) {
        this.repozytory = repozytory;
    }

    List<Student> getStudents() {
        //throw new UnsupportedOperationException();
        //return students;
        return List.offAll(this.repozytory.findAll()).map(Function());

    }

    private static Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj ->
                new Student(
                        dbObj.getId(),
                        dbObj.getName(),
                        dbObj.getNumber(),
                        dbObj.getGroup());
    }

    //    void addStudent(final Student newStudent){
//        throw new UnsupportedOperationException();
//    }
    Student addStudent(final NewStudent newStudent){
        //throw new UnsupportedOperationException();
        StudentRow created = this.repozytory.save(new StudentRow(
                newStudent.name,
                newStudent.number,
                newStudent.group);
        return getStudentRowStudentFunction().apply(created);
    }

    //Student addStudent(final NewStudent newStudent) {
        //Student created = new Student(1, "aa", "aa", "aa");
        //Student created = new Student(1, newStudent.name, newStudent.number, newStudent.group);
        //Student created = new Student(students.size() + 1, newStudent.name, newStudent.number, newStudent.group);
        //students = students.prepend(created);
        //return created;
    //}
}
