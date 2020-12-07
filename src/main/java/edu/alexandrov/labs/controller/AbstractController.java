package edu.alexandrov.labs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface AbstractController<D, C> {
    D findBy(@RequestParam C criteria);
    List<D> findAll();
    D save(@RequestBody D dto) throws ValidationException;
    ResponseEntity<Void> delete(@PathVariable Integer id);
}
