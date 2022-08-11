package org.example.controller;

import org.example.model.StudentLog;
import org.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/{id}/logs")
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public List<StudentLog> getLogsForStudent(@PathVariable(name = "id") int id) {
        return logService.getLogsForStudent(id);
    }

    @PostMapping
    public void createNewLog(@PathVariable(name = "id") int id, @RequestParam(name = "message") String message) {
        logService.createNewLog(id, message);
    }

    @PostMapping("/{logId}")
    public void updateLog(@PathVariable(name = "logId") int logId, @RequestParam(name = "message") String message) {
        logService.updateLog(logId, message);
    }
}
