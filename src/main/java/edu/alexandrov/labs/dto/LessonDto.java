package edu.alexandrov.labs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

@Data
@Builder
@AllArgsConstructor
public class LessonDto implements Serializable, Comparable<LessonDto> {

    private static final long serialVersionUID = -4862926644813430001L;
    private int id;
    private TimeTableDto timeTableDto;
    private String title;
    private String description;
    private String lector;
    private String audienceNumber;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isRemote;

    @Override
    public int compareTo(LessonDto dto) {
        LocalTime now = LocalTime.now();
        TemporalUnit minutes = ChronoUnit.MINUTES;
        return (int) (startTime.until(now, minutes) - dto.startTime.until(now, minutes));
    }
}
