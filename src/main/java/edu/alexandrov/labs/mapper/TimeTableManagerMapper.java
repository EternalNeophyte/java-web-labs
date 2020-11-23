package edu.alexandrov.labs.mapper;

import edu.alexandrov.labs.dto.TimeTableManagerDto;
import edu.alexandrov.labs.entity.TimeTableManager;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = TimeTableMapper.class)
public interface TimeTableManagerMapper extends AbstractMapper<TimeTableManager, TimeTableManagerDto> {

    @Mapping(source = "timeTableDtoList", target = "timeTables")
    @Override
    TimeTableManager toEntity(TimeTableManagerDto dto);

    @InheritInverseConfiguration
    @Override
    TimeTableManagerDto toDto(TimeTableManager entity);
}
