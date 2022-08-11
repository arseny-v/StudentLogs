package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "logs")
@NoArgsConstructor
public class StudentLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Getter
    @Setter
    @Column(name = "message")
    private String message;

    @Getter
    @Setter
    @Column(name = "date")
    private Instant createdAt;

    public StudentLog(Student student, String message, Instant instant) {
        this.student = student;
        this.message = message;
        this.createdAt = instant;
    }
}
