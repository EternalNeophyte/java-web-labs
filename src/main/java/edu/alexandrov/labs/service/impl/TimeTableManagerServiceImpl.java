package edu.alexandrov.labs.service.impl;

import edu.alexandrov.labs.dto.TimeTableManagerDto;
import edu.alexandrov.labs.entity.TimeTableManager;
import edu.alexandrov.labs.mapper.TimeTableManagerMapper;
import edu.alexandrov.labs.repository.TimeTableManagerRepository;
import edu.alexandrov.labs.service.TimeTableManagerService;
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
public class TimeTableManagerServiceImpl implements TimeTableManagerService, Validator<TimeTableManagerDto> {

    @Autowired
    private TimeTableManagerRepository repository;

    @Autowired
    private TimeTableManagerMapper mapper;

    @Override
    public TimeTableManagerDto findByIsWeekEven(boolean isWeekEven) {
        return Optional.of(mapper.toDto(repository.findByIsWeekEven(isWeekEven)))
                .orElseThrow(NoSuchElementException::new);
    }


    @Override
    public List<TimeTableManagerDto> findAll() {
        return mapper.toDtoList(repository.findAll());
    }


    @Override
    public TimeTableManagerDto save(TimeTableManagerDto dto) throws ValidationException {
        validate(dto);
        TimeTableManager timeTableManager = repository.save(mapper.toEntity(dto));
        return mapper.toDto(timeTableManager);
    }

    @Override
    public List<TimeTableManagerDto> saveAll(List<TimeTableManagerDto> dtoList) throws ValidationException {
        validate(dtoList);
        List<TimeTableManager> timeTableManagers = repository.saveAll(mapper.toEntityList(dtoList));
        return mapper.toDtoList(timeTableManagers);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
