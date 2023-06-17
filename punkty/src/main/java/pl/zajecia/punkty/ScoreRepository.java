package pl.zajecia.punkty;

import org.springframework.data.repository.CrudRepository;
import pl.zajecia.punkty.studentdb.ScoreRow;

public interface ScoreRepository extends CrudRepository<ScoreRow, Long> {
}
