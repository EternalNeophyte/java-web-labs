package edu.alexandrov.labs.service;

import edu.alexandrov.labs.dto.TimeTableDto;

public interface TimeTableService extends AbstractService<TimeTableDto> {

    TimeTableDto findByDayOfWeekRus(String dayOfWeekRus);
}
