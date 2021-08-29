package dev.patika.thirdhomework.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@JsonTypeName("VisitingResearcher")
public class VisitingResearcher extends Instructor {
    private double hourlySalary;

}
