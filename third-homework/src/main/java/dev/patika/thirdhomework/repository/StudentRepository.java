package dev.patika.thirdhomework.repository;

import dev.patika.thirdhomework.entity.Instructor;
import dev.patika.thirdhomework.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {


    List<Student> deleteAllByName(String name);
    List<Student> findAllByName(String name);

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getStudentGender();


}
