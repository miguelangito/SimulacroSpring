package com.riwi.simulacro.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(length = 100, nullable = false)
    private String courseName;

    @Lob
    private String description;

    @OneToMany(
        mappedBy = "courses",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Enrollment> enrollment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "users_id,",
        referencedColumnName = "id"
        )
    private Users users;

    @OneToMany(
        mappedBy = "courses",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Message> message;

    @OneToMany(
        mappedBy = "courses",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false

    )
    private List<Lessons> lessons;
}
