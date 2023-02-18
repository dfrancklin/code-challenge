package com.company.lms.backend.controllers.timelogs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.timelogs.dtos.TimeLogResponse;
import com.company.lms.backend.controllers.timelogs.mappers.TimeLogResponseMapper;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.services.timelogs.LoadTimeLogByIdService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/timelogs")
@RequiredArgsConstructor
public class LoadTimeLogByIdController {

    private final LoadTimeLogByIdService loadTimeLogByIdService;

    @GetMapping("/{id}")
    public TimeLogResponse load(@PathVariable Long id) {
        TimeLog timeLog = loadTimeLogByIdService.load(id);
        return TimeLogResponseMapper.map(timeLog);
    }

}
