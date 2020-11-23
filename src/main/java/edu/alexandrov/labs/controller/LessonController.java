package edu.alexandrov.labs.controller;

import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.service.LessonService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/lessons")
@AllArgsConstructor
@Log
@CrossOrigin
public class LessonController implements Controller<LessonDto, String> {

    private final LessonService service;

    @GetMapping("/findBy")
    @Override
    public LessonDto findBy(String title) {
        log.info("Controller handling find lesson by title: " + title);
        return service.findByTitle(title);
    }

    @GetMapping("/findAll")
    @Override
    public List<LessonDto> findAll() {
        log.info("Controller handling find all lessons");
        return service.findAll();
    }

    @PostMapping("/save")
    @Override
    public LessonDto save(LessonDto dto) throws ValidationException {
        log.info("Controller handling save lesson: " + dto);
        return service.save(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Void> delete(Integer id) {
        log.info("Controller handling delete lesson: " + id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
