package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
@NoArgsConstructor
public class Log {

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
    private Date date;

    public Log(Student student, String message, Date date) {
        this.student = student;
        this.message = message;
        this.date = date;
    }
}
