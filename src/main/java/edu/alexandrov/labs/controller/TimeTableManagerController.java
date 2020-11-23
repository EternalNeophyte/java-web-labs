package edu.alexandrov.labs.controller;

import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.dto.TimeTableDto;
import edu.alexandrov.labs.dto.TimeTableManagerDto;
import edu.alexandrov.labs.service.TimeTableManagerService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/timeTableManagers")
@AllArgsConstructor
@Log
@CrossOrigin
public class TimeTableManagerController implements Controller<TimeTableManagerDto, Boolean> {

    private final TimeTableManagerService service;

    @GetMapping("/findBy")
    @Override
    public TimeTableManagerDto findBy(Boolean isWeekEven) {
        log.info("Controller handling find time table manager by parity: " + isWeekEven);
        return service.findByIsWeekEven(isWeekEven);
    }

    @GetMapping("/findAll")
    @Override
    public List<TimeTableManagerDto> findAll() {
        log.info("Controller handling find all time table managers");
        return service.findAll();
    }

    @PostMapping("/save")
    @Override
    public TimeTableManagerDto save(TimeTableManagerDto dto) throws ValidationException {
        log.info("Controller handling save time table manager: " + dto);
        return service.save(dto);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Void> delete(Integer id) {
        log.info("Controller handling delete time table manager: " + id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateAll")
    public List<TimeTableManagerDto> updateAll() throws ValidationException {
        String firstBuildingNotice = "\n(!) Пара проходит в 1-ом корпусе. " +
                "Рекомендуемый транспорт до ул. Льва Толстого, 23:\n> Автобус 47\n> Трамвай 20";
        List<TimeTableManagerDto> dtoList = new ArrayList<>(List.of(
                TimeTableManagerDto.builder()
                        .isWeekEven(false)
                        .timeTableDtoList(List.of(
                                TimeTableDto.builder()
                                        .dayOfWeek("MONDAY")
                                        .dayOfWeekRus("ПОНЕДЕЛЬНИК")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Базы данных")
                                                        .description("Лабораторная")
                                                        .lector("Захарова О.И.")
                                                        .audienceNumber("4-08")
                                                        .startTime(LocalTime.of(13, 35))
                                                        .endTime(LocalTime.of(15, 10))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("РВПРС на Java")
                                                        .description("Лабораторная")
                                                        .lector("Герасимов А.М.")
                                                        .audienceNumber("2-35(2)")
                                                        .startTime(LocalTime.of(15, 20))
                                                        .endTime(LocalTime.of(16, 55))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder().title("КПО")
                                                        .description("Лабораторная")
                                                        .lector("Расеева Е.В.")
                                                        .audienceNumber("2-33(2)")
                                                        .startTime(LocalTime.of(17, 05))
                                                        .endTime(LocalTime.of(18, 40))
                                                        .isRemote(true)
                                                        .build()
                                                ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("TUESDAY")
                                        .dayOfWeekRus("ВТОРНИК")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Сети и телекоммуникации")
                                                        .description("Лабораторная" + firstBuildingNotice)
                                                        .lector("Лысиков А.А.")
                                                        .audienceNumber("441")
                                                        .startTime(LocalTime.of(11, 40))
                                                        .endTime(LocalTime.of(13, 15))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("Электроника")
                                                        .description("Практика" + firstBuildingNotice)
                                                        .lector("Арефьев А.С.")
                                                        .audienceNumber("335")
                                                        .startTime(LocalTime.of(13, 35))
                                                        .endTime(LocalTime.of(15, 10))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("WEDNESDAY")
                                        .dayOfWeekRus("СРЕДА")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("КПО")
                                                        .description("Лекция")
                                                        .lector("Мостовой Я.А.")
                                                        .audienceNumber("2-08")
                                                        .startTime(LocalTime.of(8, 10))
                                                        .endTime(LocalTime.of(9, 45))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("РВПРС на Java")
                                                        .description("Лекция")
                                                        .lector("Герасимов А.М.")
                                                        .audienceNumber("2-08")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("Базы данных")
                                                        .description("Лекция")
                                                        .lector("Захарова О.И.")
                                                        .audienceNumber("2-01")
                                                        .startTime(LocalTime.of(11, 40))
                                                        .endTime(LocalTime.of(13, 15))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("THURSDAY")
                                        .dayOfWeekRus("ЧЕТВЕРГ")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Математическое программирование")
                                                        .description("Лабораторная")
                                                        .lector("Аронов В.Ю.")
                                                        .audienceNumber("2-35(2)")
                                                        .startTime(LocalTime.of(8, 10))
                                                        .endTime(LocalTime.of(9, 45))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("Базы данных")
                                                        .description("Лабораторная")
                                                        .lector("Захарова О.И.")
                                                        .audienceNumber("5-10")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("FRIDAY")
                                        .dayOfWeekRus("ПЯТНИЦА")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Правоведение")
                                                        .description("Лекция")
                                                        .lector("Фоменко Р.В.")
                                                        .audienceNumber("2-07")
                                                        .startTime(LocalTime.of(8, 10))
                                                        .endTime(LocalTime.of(9, 45))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("Математическое программирование")
                                                        .description("Лекция ДЕДА. Рекомендуется смотреть на ЭВМ")
                                                        .lector("Тарасов В.Н.")
                                                        .audienceNumber("2-07")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("КПО")
                                                        .description("Лабораторная")
                                                        .lector("Расеева Е.В.")
                                                        .audienceNumber("4-08")
                                                        .startTime(LocalTime.of(11, 40))
                                                        .endTime(LocalTime.of(13, 15))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build()
                        ))
                        .build(),
                TimeTableManagerDto.builder()
                        .isWeekEven(true)
                        .timeTableDtoList(List.of(
                                TimeTableDto.builder()
                                        .dayOfWeek("MONDAY")
                                        .dayOfWeekRus("ПОНЕДЕЛЬНИК")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Правоведение")
                                                        .description("Практика")
                                                        .lector("Фоменко Р.В.")
                                                        .audienceNumber("1-12")
                                                        .startTime(LocalTime.of(13, 35))
                                                        .endTime(LocalTime.of(15, 10))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("РВПРС на Java")
                                                        .description("Лабораторная")
                                                        .lector("Герасимов А.М.")
                                                        .audienceNumber("2-35(2)")
                                                        .startTime(LocalTime.of(15, 20))
                                                        .endTime(LocalTime.of(16, 55))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("TUESDAY")
                                        .dayOfWeekRus("ВТОРНИК")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Сети и телекоммуникации")
                                                        .description("Лабораторная" + firstBuildingNotice)
                                                        .lector("Лысиков А.А.")
                                                        .audienceNumber("441")
                                                        .startTime(LocalTime.of(11, 40))
                                                        .endTime(LocalTime.of(13, 15))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("Электроника")
                                                        .description("Лабораторная" + firstBuildingNotice)
                                                        .lector("Арефьев А.С.")
                                                        .audienceNumber("335")
                                                        .startTime(LocalTime.of(13, 35))
                                                        .endTime(LocalTime.of(15, 10))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("WEDNESDAY")
                                        .dayOfWeekRus("СРЕДА")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("КПО")
                                                        .description("Лекция")
                                                        .lector("Мостовой Я.А.")
                                                        .audienceNumber("2-08")
                                                        .startTime(LocalTime.of(8, 10))
                                                        .endTime(LocalTime.of(9, 45))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("РВПРС на Java")
                                                        .description("Лекция")
                                                        .lector("Герасимов А.М.")
                                                        .audienceNumber("2-08")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("Базы данных")
                                                        .description("Лекция")
                                                        .lector("Захарова О.И.")
                                                        .audienceNumber("2-01")
                                                        .startTime(LocalTime.of(11, 40))
                                                        .endTime(LocalTime.of(13, 15))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("THURSDAY")
                                        .dayOfWeekRus("ЧЕТВЕРГ")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Математическое программирование")
                                                        .description("Лабораторная")
                                                        .lector("Аронов В.Ю.")
                                                        .audienceNumber("2-35(2)")
                                                        .startTime(LocalTime.of(8, 10))
                                                        .endTime(LocalTime.of(9, 45))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder().title("Базы данных")
                                                        .description("Лабораторная")
                                                        .lector("Захарова О.И.")
                                                        .audienceNumber("5-10")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("FRIDAY")
                                        .dayOfWeekRus("ПЯТНИЦА")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Базы данных")
                                                        .description("Лабораторная")
                                                        .lector("Захарова О.И.")
                                                        .audienceNumber("2-07")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder()
                                                        .title("КПО")
                                                        .description("Лабораторная")
                                                        .lector("Расеева Е.В.")
                                                        .audienceNumber("4-08")
                                                        .startTime(LocalTime.of(11, 40))
                                                        .endTime(LocalTime.of(13, 15))
                                                        .isRemote(true)
                                                        .build()

                                        ))
                                        .build(),
                                TimeTableDto.builder()
                                        .dayOfWeek("FRIDAY")
                                        .dayOfWeekRus("ПЯТНИЦА")
                                        .lessonDtoList(List.of(
                                                LessonDto.builder()
                                                        .title("Сети и телекоммуникации")
                                                        .description("Лекция")
                                                        .lector("Лысиков А.А.")
                                                        .audienceNumber("314")
                                                        .startTime(LocalTime.of(8, 10))
                                                        .endTime(LocalTime.of(9, 45))
                                                        .isRemote(true)
                                                        .build(),
                                                LessonDto.builder().title("Электроника")
                                                        .description("Лекция")
                                                        .lector("Арефьев А.С.")
                                                        .audienceNumber("308")
                                                        .startTime(LocalTime.of(9, 55))
                                                        .endTime(LocalTime.of(11, 30))
                                                        .isRemote(true)
                                                        .build()
                                        ))
                                        .build()
                        ))
                        .build()
        ));
        return service.saveAll(dtoList);
    }
}
