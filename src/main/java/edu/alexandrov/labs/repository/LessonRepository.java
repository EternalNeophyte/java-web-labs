package edu.alexandrov.labs.repository;

import edu.alexandrov.labs.entity.Lesson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Lesson findByTitle(String title);
}
