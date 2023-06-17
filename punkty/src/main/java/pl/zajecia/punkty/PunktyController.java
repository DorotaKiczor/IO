package pl.zajecia.punkty;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.punkty.studentdb.ScoreRow;
import pl.zajecia.punkty.studentdb.StudentRepozytory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    private StudentRepozytory repozytory;
    private ScoreRow scoreRepository;
    private List<String> users=new CopyOnWriteArrayList<>();
    private StudentService service = new StudentService(repozytory, scoreRepository);
    public PunktyController(StudentService service) {
        this.service = service;
    }
//    @RequestMapping(value = "/users",method = RequestMethod.GET)
//    public List<String> getUsers() {
//        return this.users;
//    }
    @RequestMapping(value = "/students", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
        return this.service.getStudents().asJava();
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
     public int addUser(@RequestBody String name) {
         this.users.add(name);
         return this.users.size();
     }
    @RequestMapping(value = "/students", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUser(@RequestBody NewStudent student) {
        return this.service.addStudent(student);
    }
    @PathVariable("id") long id;
    @PathVariable("number") String number;
    @RequestMapping(value = "/students/{id}/number/{number}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUser(@RequestBody NewStudent student) {
        return this.service.changeNumber(id, number).orElseThrow(
                () -> new IllegalArgumentException
                        ("Student o id: " + id + " does not exist") );
    }
}
