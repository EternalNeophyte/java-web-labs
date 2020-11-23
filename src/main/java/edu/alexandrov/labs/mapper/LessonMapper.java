package edu.alexandrov.labs.mapper;

import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.entity.Lesson;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = TimeTableMapper.class)
public interface LessonMapper extends AbstractMapper<Lesson, LessonDto> {

    @Mapping(source = "timeTableDto", target = "timeTable")
    @Override
    Lesson toEntity(LessonDto dto);

    @InheritInverseConfiguration
    @Override
    LessonDto toDto(Lesson entity);
}
