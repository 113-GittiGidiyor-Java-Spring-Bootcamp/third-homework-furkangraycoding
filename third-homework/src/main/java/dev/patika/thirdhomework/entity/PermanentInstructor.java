package dev.patika.thirdhomework.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@JsonTypeName("PermanentInstructor")
public class PermanentInstructor extends dev.patika.thirdhomework.entity.Instructor {

    private double fixedSalary;


}
