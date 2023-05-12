//package pl.zajecia.punkty;
//
//import io.vavr.collection.List;
//import org.junit.Assert;
//import org.junit.Test;
////import java.util.List;
//import static org.junit.Assert.*;
//
//
//public class StudentServiceTest11 {
//    @Test
//    public void getEmptyList() {
//        final StudentServiceTest11 service = new StudentServiceTest11();
//        List<Student> students = service.getStudents();
//        assertTrue(students.isEmpty());
//    }
//
//    @Test
//    public void addStudent() {
//        final StudentServiceTest11 service = new StudentServiceTest11();
//        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
//        assertNotNull(created);
//    }
//
//    @Test
//    public void addStudentIsReturned() {
//        final StudentServiceTest11 service = new StudentServiceTest11();
//        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
//        final List<Student> all = service.getStudents();
//        //assertEquals("Student1",all.get(0).name);
//        assertEquals("Student1", all.head().name);
//    }
//
//    @Test
//    public void addStudentHasNewId() {
//        final StudentServiceTest11 service = new StudentServiceTest11();
//        final Student created1 = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
//        final Student created2 = service.addStudent(new NewStudent("Student2", "1-2-4", "IP"));
//        assertNotEquals(created1.id,created2.id);
//        Assert.assertEquals(2,service.getStudents().size());
//    }
//}