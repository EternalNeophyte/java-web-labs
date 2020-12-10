package edu.alexandrov.labs.mapper;

import edu.alexandrov.labs.dto.LessonDto;
import edu.alexandrov.labs.entity.Lesson;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface LessonMapper extends AbstractMapper<Lesson, LessonDto> {

    @Mapping(source = "timeTableDto", target = "timeTable")
    @Override
    Lesson toEntity(LessonDto dto);

    @InheritInverseConfiguration
    @Override
    LessonDto toDto(Lesson entity);

    @Override
    List<Lesson> toEntityList(List<LessonDto> dtoList);

    @Override
    List<LessonDto> toDtoList(List<Lesson> entityList);
}
