package edu.alexandrov.labs.controller;

import edu.alexandrov.labs.behavior.Interactor;
import edu.alexandrov.labs.dto.TimeTableManagerDto;
import edu.alexandrov.labs.service.TimeTableManagerService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
@Log
@CrossOrigin
public class MainController implements AbstractController<TimeTableManagerDto, Boolean> {

    private final TimeTableManagerService service;
    private final Interactor interactor;

    @GetMapping("/findBy")
    @Override
    public TimeTableManagerDto findBy(Boolean isWeekEven) {
        log.info("AbstractController handling find time table manager by parity: " + isWeekEven);
        return service.findByIsWeekEven(isWeekEven);
    }

    @GetMapping("/findAll")
    @Override
    public List<TimeTableManagerDto> findAll() {
        log.info("AbstractController handling find all time table managers");
        return service.findAll();
    }

    @PostMapping("/save")
    @Override
    public TimeTableManagerDto save(TimeTableManagerDto dto) throws ValidationException {
        log.info("AbstractController handling save time table manager: " + dto);
        return service.save(dto);
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Void> delete(Integer id) {
        log.info("AbstractController handling delete time table manager: " + id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    /*
    Тот самый контроллер
     */
    @GetMapping("/index")
    public String showDefaultView(Model model) {
        TimeTableManagerDto tableManagerDto = (TimeTableManagerDto) interactor.getCurrentTimeTables();
        log.info("Handling /default request with " + tableManagerDto.toString());
        model.addAttribute("timeTables", tableManagerDto.getTimeTableDtoList());
        return "index";
    }

    @GetMapping("/command/{value}")
    public String executeCommand() {
        //поиск. строка
        return "index";
    }

    @GetMapping("/edit")
    public String editDescription() {
        //кнопка редактировать
        return "index";
    }
}
