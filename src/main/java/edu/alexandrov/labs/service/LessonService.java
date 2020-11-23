package edu.alexandrov.labs.service;

import edu.alexandrov.labs.dto.LessonDto;

public interface LessonService extends AbstractService<LessonDto> {

    LessonDto findByTitle(String title);
}
