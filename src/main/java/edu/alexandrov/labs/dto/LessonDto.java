package edu.alexandrov.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
public class LessonDto {

    private int id;
    private TimeTableDto timeTableDto;
    private String title;
    private String description;
    private String lector;
    private String audienceNumber;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isRemote;

}
