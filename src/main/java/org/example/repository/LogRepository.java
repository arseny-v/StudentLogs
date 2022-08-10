package org.example.repository;

import org.example.model.Log;
import org.example.model.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class LogRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public LogRepository(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Log> getLogsForStudent(int id) {

        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        Hibernate.initialize(student.getLogs());
        List<Log> logs = student.getLogs();

        return logs;
    }

    @Transactional
    public void add(int id, String message) {

        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        Log log = new Log(student, message, new Date());
        session.save(log);
    }

    @Transactional
    public void update(int logId, String message) {
        Session session = sessionFactory.getCurrentSession();
        Log log = session.get(Log.class, logId);
        log.setMessage(message);
    }
}
