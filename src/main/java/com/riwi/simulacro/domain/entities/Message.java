package com.riwi.simulacro.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Lob
    private String messageContent;

    private LocalDate sentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "instructor_id",
        referencedColumnName = "id"
    )
    private Users usersInstructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "student_id",
        referencedColumnName = "id"
    )
    private Users usersStudent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "course_id",
        referencedColumnName = "id"
    )
    private Course courses;
}
