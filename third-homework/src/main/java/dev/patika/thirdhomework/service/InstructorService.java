package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.entity.Course;
import dev.patika.thirdhomework.entity.Instructor;

import dev.patika.thirdhomework.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {

    private final InstructorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> insList = new ArrayList<>();
        Iterable<Instructor> instructorIter = repository.findAll();
        instructorIter.iterator().forEachRemaining(insList::add);
        return insList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return repository.save(instructor);
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        repository.delete(instructor);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return repository.save(instructor);
    }

    @Override
    @Transactional
    public void updateById(Instructor instructor, int id) {
        Instructor instructor1 = this.findById(id);
        instructor1.setAddress(instructor.getAddress());
        instructor1.setName(instructor.getName());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setInstructorCoursesList(instructor.getInstructorCoursesList());
        repository.save(instructor1);
    }


    public List<Instructor> getMaxSalary() {

        List<Instructor>  result= repository.getMaxSalary();

        List<Instructor> out = new ArrayList<>();;
        for(int i = 0; i < 3; i++) {
            out.add(result.get(i));
        }
        return out;
    }

    public List<Instructor> getMinSalary() {

        List<Instructor>  result= repository.getMinSalary();

        List<Instructor> out = new ArrayList<>();;
        for(int i = 0; i < 3; i++) {
            out.add(result.get(i));
        }
        return out;
    }
}
