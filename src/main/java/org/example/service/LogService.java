package org.example.service;

import org.example.model.Log;
import org.example.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public List<Log> getLogsForStudent(int id) {

        return logRepository.getLogsForStudent(id);
    }

    public void createNewLog(int id, String message) {

        logRepository.add(id, message);
    }

    public void updateLog(int logId, String message) {

        logRepository.update(logId, message);
    }
}
