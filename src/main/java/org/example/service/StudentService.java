package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {

        return studentRepository.getAll();
    }

    public void remove(int id) {

        studentRepository.remove(id);
    }

    public void addNewStudent(Student student) {

        studentRepository.save(student);
    }
}
