package edu.alexandrov.labs.controller;

import edu.alexandrov.labs.behavior.Interactor;
import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.dto.TimeTableManagerDto;
import edu.alexandrov.labs.service.LessonService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@Controller
@RequestMapping
@AllArgsConstructor
@Log
@CrossOrigin
public class MainController {

    private final LessonService lessonService;
    private final Interactor interactor;

    @GetMapping("/index")
    public String showDefaultView(Model model) {
        TimeTableManagerDto tableManagerDto = (TimeTableManagerDto) interactor.getCurrentTimeTables();
        log.info("Handling /default request with " +
                tableManagerDto.getTimeTableDtoList().size() + " time tables");
        model.addAttribute("timeTables", tableManagerDto.getTimeTableDtoList());
        return "index";
    }

    @GetMapping("/link/{day}")
    public String switchDay(@PathVariable("day") String day, Model model) {
        model.addAttribute("timeTables", interactor.getTimeTableBy(day));
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String editDescription(@PathVariable("id") Integer id, Model model) {
        LessonDto lessonDto = lessonService.findById(id);
        model.addAttribute("lesson", lessonDto);
        model.addAttribute("dayOfWeek", lessonDto.getTimeTableDto().getDayOfWeekRus());
        return "edit";
    }

    @PostMapping("/update/{isRemote}/{id}")
    public String updateDescription(@PathVariable("id") Integer id,
                                    @PathVariable("isRemote") boolean isRemote,
                                    @ModelAttribute("lesson") LessonDto lessonDto, Model model) {
        log.info(lessonDto.toString());
        lessonDto.setTimeTableDto(lessonService.findById(id).getTimeTableDto());
        try {
            lessonService.save(lessonDto);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        TimeTableManagerDto tableManagerDto = (TimeTableManagerDto) interactor.getCurrentTimeTables();
        model.addAttribute("timeTables", tableManagerDto.getTimeTableDtoList());
        return "redirect:/index";
    }

    @GetMapping("/cancel")
    public String cancelDescription() {
        return "redirect:/index";
    }
}
