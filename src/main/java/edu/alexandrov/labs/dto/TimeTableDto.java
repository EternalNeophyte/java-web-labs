package edu.alexandrov.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TimeTableDto implements Serializable {

    private static final long serialVersionUID = -4862926644813430002L;
    private int id;
    private TimeTableManagerDto timeTableManagerDto;
    private List<LessonDto> lessonDtoList;
    private String dayOfWeek;
    private String dayOfWeekRus;

}
