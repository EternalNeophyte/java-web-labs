package edu.alexandrov.labs.service;

import edu.alexandrov.labs.dto.TimeTableManagerDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface TimeTableManagerService extends AbstractService<TimeTableManagerDto> {

    TimeTableManagerDto findByIsWeekEven(boolean isWeekEven);
    List<TimeTableManagerDto> saveAll(List<TimeTableManagerDto> dtoList) throws ValidationException;
}

