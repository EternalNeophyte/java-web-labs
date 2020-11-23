package edu.alexandrov.labs.repository;

import edu.alexandrov.labs.entity.TimeTableManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableManagerRepository extends JpaRepository<TimeTableManager, Integer> {

    TimeTableManager findByIsWeekEven(boolean isWeekEven);
}
