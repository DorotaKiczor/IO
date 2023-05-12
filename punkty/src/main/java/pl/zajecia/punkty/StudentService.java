package pl.zajecia.punkty;

import io.vavr.collection.List;

//import io.vavr.collection.List;
public class StudentService {
    private List<Student> students = List.empty();

    List<Student> getStudents() {
        //throw new UnsupportedOperationException();
        return students;
    }
//    void addStudent(final Student newStudent){
//        throw new UnsupportedOperationException();
//    }
//    Student addStudent(final NewStudent newStudent){
//        throw new UnsupportedOperationException();
//    }

    Student addStudent(final NewStudent newStudent) {
        //Student created = new Student(1, "aa", "aa", "aa");
        //Student created = new Student(1, newStudent.name, newStudent.number, newStudent.group);
        Student created = new Student(students.size() + 1, newStudent.name, newStudent.number, newStudent.group);
        students = students.prepend(created);
        return created;
    }
}
