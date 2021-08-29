package dev.patika.thirdhomework.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private int credit;

    //Many to one
    @ManyToOne
    private Instructor instructor;

    @ManyToMany(mappedBy = "studentCourses")
    private List<Student> studentList = new ArrayList<>();

}
