package edu.alexandrov.labs.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TimeTableManagerDto implements Serializable {

    private static final long serialVersionUID = -4862926644813430003L;
    private int id;
    private List<TimeTableDto> timeTableDtoList;
    private boolean isWeekEven;
}
