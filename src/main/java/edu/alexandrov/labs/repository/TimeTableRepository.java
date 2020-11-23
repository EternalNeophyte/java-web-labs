package edu.alexandrov.labs.repository;

import edu.alexandrov.labs.entity.TimeTable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {

    TimeTable findByDayOfWeekRus(String dayOfWeekRus);
}
