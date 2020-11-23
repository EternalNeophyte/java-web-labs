package edu.alexandrov.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TimeTableManagerDto {

    private int id;
    private List<TimeTableDto> timeTableDtoList;
    private boolean isWeekEven;
}
