package edu.alexandrov.labs.service.impl;

import edu.alexandrov.labs.dto.TimeTableDto;
import edu.alexandrov.labs.entity.TimeTable;
import edu.alexandrov.labs.mapper.TimeTableMapper;
import edu.alexandrov.labs.repository.TimeTableRepository;
import edu.alexandrov.labs.service.TimeTableService;
import edu.alexandrov.labs.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TimeTableServiceImpl implements TimeTableService, Validator<TimeTableDto> {

    @Autowired
    private TimeTableRepository repository;

    @Autowired
    private TimeTableMapper mapper;

    @Override
    public TimeTableDto findByDayOfWeek(String dayOfWeek) {
        return Optional.of(mapper.toDto(repository.findByDayOfWeek(dayOfWeek)))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<TimeTableDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public TimeTableDto save(TimeTableDto dto) throws ValidationException {
        validate(dto);
        TimeTable timeTable = repository.save(mapper.toEntity(dto));
        return mapper.toDto(timeTable);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
