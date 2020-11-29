package edu.alexandrov.labs.controller;

import edu.alexandrov.labs.behavior.Interactor;
import edu.alexandrov.labs.dto.TimeTableDto;
import edu.alexandrov.labs.service.TimeTableService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/timeTables")
@AllArgsConstructor
@Log
@CrossOrigin
public class TimeTableController implements Controller<TimeTableDto, String> {

    private final TimeTableService service;
    private final Interactor interactor;

    @GetMapping("/findBy")
    @Override
    public TimeTableDto findBy(String dayOfWeekRus) {
        log.info("Controller handling find time table by day: " + dayOfWeekRus);
        return service.findByDayOfWeek(dayOfWeekRus);
    }

    @GetMapping("/findAll")
    @Override
    public List<TimeTableDto> findAll() {
        log.info("Controller handling find all time tables");
        return service.findAll();
    }

    @PostMapping("/save")
    @Override
    public TimeTableDto save(TimeTableDto dto) throws ValidationException {
        log.info("Controller handling save time table: " + dto);
        return service.save(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Void> delete(Integer id) {
        log.info("Controller handling delete time table: " + id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }





}
