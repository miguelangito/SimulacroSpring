package com.riwi.simulacro.domain.entities;

import java.util.List;

import com.riwi.simulacro.util.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String password;
    
    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100)
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(
        mappedBy = "users",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
        )
    private List<Enrollment> enrollment;

    @OneToMany(
        mappedBy = "users",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
        )
    private List<Course> courses;

    @OneToMany(
        mappedBy = "users",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
        )  
    private List<Submission> submission;

    @OneToMany(
        mappedBy = "usersInstructor",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
        )
    private List<Message> messageInstructor;


    @OneToMany(
        mappedBy = "usersStudent",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = false
        )
    private List<Message> messageStudent;
}
