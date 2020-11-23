package edu.alexandrov.labs.service.impl;

import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.entity.Lesson;
import edu.alexandrov.labs.mapper.LessonMapper;
import edu.alexandrov.labs.repository.LessonRepository;
import edu.alexandrov.labs.service.LessonService;
import edu.alexandrov.labs.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Primary
@Service
@AllArgsConstructor
@NoArgsConstructor
public class LessonServiceImpl implements LessonService, Validator<LessonDto> {

    @Autowired
    private LessonRepository repository;

    @Autowired
    private LessonMapper mapper;

    @Override
    public LessonDto findByTitle(String title) {
        return Optional.of(mapper.toDto(repository.findByTitle(title)))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<LessonDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public LessonDto save(LessonDto lessonDto) throws ValidationException {
        validate(lessonDto);
        Lesson savedLesson = repository.save(mapper.toEntity(lessonDto));
        return mapper.toDto(savedLesson);
    }

    @Override
    public void delete(Integer lessonId) {
        repository.deleteById(lessonId);
    }
}
