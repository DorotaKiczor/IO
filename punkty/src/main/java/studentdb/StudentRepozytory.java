package studentdb;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepozytory extends CrudRepository<StudentRow, Long> {


}
