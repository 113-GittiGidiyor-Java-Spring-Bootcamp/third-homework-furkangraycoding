package dev.patika.thirdhomework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String birthDate;
    private String address;
    private String gender;

    @ManyToMany
    private List<dev.patika.thirdhomework.entity.Course> studentCourses = new ArrayList<>();

}
