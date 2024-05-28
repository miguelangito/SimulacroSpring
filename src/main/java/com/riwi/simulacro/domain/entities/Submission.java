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

@Entity(name = "submissions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Submission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;
    private LocalDate submissionDate;
    private Double grade;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "users_id",
        referencedColumnName = "id"
        )
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "assignments_id",
        referencedColumnName = "id"
        )
    private Assignment assignments;
}
