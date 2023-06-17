package pl.zajecia.punkty;

import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.zajecia.punkty.studentdb.StudentRepozytory;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentRepozytory repozytory;
    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService(repozytory, scoreRepository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }
    @Test
    public void addStudent(final NewStudent newStudent) {
        final StudentService service = new StudentService(repozytory, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);
    }
    @Test
    public void addStudentIsReturned() {
        final StudentService service = new StudentService(repozytory, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        //assertEquals("Student1",all.get(0).name);
        assertEquals(created.name, all.head().name);
    }
    @Test
    public void addStudentHasNewId() {
        final StudentService service = new StudentService(repozytory, scoreRepository);
        final Student created1 = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "1-2-4", "IP"));
        assertNotEquals(created1.id,created2.id);
        assertEquals(2,service.getStudents().size());
    }
    @After
    public void cleanAfterTest() {
        this.repozytory.deleteAll();
    }
}