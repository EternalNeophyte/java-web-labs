package edu.alexandrov.labs.validation;

import javax.xml.bind.ValidationException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public interface Validator<D> {

    default void validate(D dto) throws ValidationException {
        if(Objects.isNull(dto)) {
            throw new ValidationException("Object is null");
        }
        else {
            for(Field field : dto.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if(Objects.isNull(field.get(dto)) && !field.getType().equals(int.class)) {
                        throw new ValidationException("Field " + field.getName() + " is null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    default void validate(List<D> dtoList) throws ValidationException {
        for(D dto : dtoList) {
            validate(dto);
        }
    }
}
