package edu.alexandrov.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TimeTableDto {

    private int id;
    private TimeTableManagerDto timeTableManagerDto;
    private List<LessonDto> lessonDtoList;
    private String dayOfWeek;
    private String dayOfWeekRus;

}
