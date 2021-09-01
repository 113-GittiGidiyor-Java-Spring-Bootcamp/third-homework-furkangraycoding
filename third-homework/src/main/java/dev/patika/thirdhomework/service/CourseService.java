package dev.patika.thirdhomework.service;


import dev.patika.thirdhomework.entity.Course;

import dev.patika.thirdhomework.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {


    private final CourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIter = repository.findAll();
        courseIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return repository.save(course);
    }


    @Override
    @Transactional
    public void delete(Course course) {
        repository.delete(course);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    @Transactional
    public Course update(Course course) {
        return repository.save(course);
    }

    @Override
    @Transactional
    public void updateById(Course course, int id) {
        Course course1 = this.findById(id);
        course1.setCourseCode(course.getCourseCode());
        course1.setCourseName(course.getCourseName());
        course1.setCredit(course.getCredit());
        course1.setInstructor(course.getInstructor());
        course1.setStudentList(course.getStudentList());
        repository.save(course1);
    }


    @Transactional
    public void deleteByCourseName(String name) {
        repository.deleteByCourseName(name);
    }

    @Transactional(readOnly = true)
    public List<Course> findAllByCourseName(String name) {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIter = repository.findAllByCourseName(name);
        courseIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }


}
