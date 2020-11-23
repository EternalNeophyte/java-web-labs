package edu.alexandrov.labs.service;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface AbstractService<D> {

    List<D> findAll();
    D save(D dto) throws ValidationException;
    void delete(Integer id);
}
