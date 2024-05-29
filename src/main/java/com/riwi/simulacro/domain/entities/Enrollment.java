package com.riwi.simulacro.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "enrollments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Enrollment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private LocalDate enrollmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "users_id",
        referencedColumnName = "id"
        )
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "courses_id",
        referencedColumnName = "id"
    )
    private Course courses;
}
