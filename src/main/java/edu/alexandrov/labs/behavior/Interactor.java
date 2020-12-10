package edu.alexandrov.labs.behavior;

import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.dto.TimeTableDto;
import edu.alexandrov.labs.dto.TimeTableManagerDto;
import edu.alexandrov.labs.service.TimeTableManagerService;
import edu.alexandrov.labs.service.TimeTableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class Interactor implements TriggerHandler<Interactor, Serializable> {

    private final LocalDate REFERENCE_TIME_POINT = LocalDate.of(2020, Month.AUGUST, 30);
    private final TimeTableManagerService timeTableManagerService;
    private final TimeTableService timeTableService;

    private boolean isWeekEven() {
        return ChronoUnit.WEEKS.between(REFERENCE_TIME_POINT, LocalDate.now()) % 2 != 0;
    }

    private Serializable getTimeTableWithShift(int daysToShift) {
        return timeTableService.findByDayOfWeek(LocalDate.now()
                .plusDays(daysToShift)
                .getDayOfWeek()
                .toString());
    }

    public Serializable submitAndGet(String request) {
        try {
            return handleTriggers(this, request);
        } catch (InvocationTargetException | IllegalAccessException |
                NoSuchMethodException | NoSuchElementException e) {
            return getTimeTableToday();
        }
    }

    @TriggeredBy(triggers = {"l3 l+", "Следующая пара",
                             "Какая пара следующая",
                             "Лерфис следующая пара"})
    public Serializable getNextLesson() {
        return ((TimeTableDto) getTimeTableToday())
                .getLessonDtoList()
                .stream()
                .filter(lessonDto -> LocalTime.now().isBefore(lessonDto.getStartTime()))
                .max(LessonDto::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    @TriggeredBy(triggers = {"l3 tt", "Какие пары сегодня",
                             "Лерфис расписание на сегодня"})
    public Serializable getTimeTableToday() {
        return getTimeTableWithShift(0);
    }

    @TriggeredBy(triggers = {"l3 tt+", "Какие пары завтра",
                             "Лерфис расписание на завтра"})
    public Serializable getTimeTableTomorrow() {
        return getTimeTableWithShift(1);
    }

    @TriggeredBy(triggers = {"l3 tt*", "Лерфис расписание",
                             "Лервис эта неделя",
                             "Лерфис расписание на эту неделю"})
    public Serializable getCurrentTimeTables() {
        return timeTableManagerService.findByIsWeekEven(isWeekEven());
    }

    @TriggeredBy(triggers = {"l3 tt*+", "Лерфис следующая неделя",
                             "Лерфис расписание на следующую неделю"})
    public Serializable getNextTimeTables() {
        return timeTableManagerService.findByIsWeekEven(!isWeekEven());
    }

    @TriggeredBy(triggers = {"l3 tt%2", "Лерфис четная неделя",
                              "Лерфис расписание на четную неделю"})
    public Serializable getEvenTimeTables() {
        return timeTableManagerService.findByIsWeekEven(true);
    }

    @TriggeredBy(triggers = {"l3 tt!%2", "Лерфис нечетная неделя",
                             "Лерфис расписание на нечетную неделю"})
    public Serializable getOddTimeTables() {
        return timeTableManagerService.findByIsWeekEven(false);
    }

    public List<TimeTableDto> getTimeTableBy(String day) {
        return ((TimeTableManagerDto) getCurrentTimeTables())
                .getTimeTableDtoList()
                .stream()
                .filter(t -> t.getDayOfWeek().equals(day))
                .collect(Collectors.toList());
    }
}
