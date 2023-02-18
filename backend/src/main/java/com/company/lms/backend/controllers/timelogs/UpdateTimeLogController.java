package com.company.lms.backend.controllers.timelogs;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.timelogs.dtos.TimeLogResponse;
import com.company.lms.backend.controllers.timelogs.dtos.UpdateTimeLogRequest;
import com.company.lms.backend.controllers.timelogs.mappers.TimeLogResponseMapper;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.services.timelogs.UpdateTimeLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/timelogs")
@RequiredArgsConstructor
public class UpdateTimeLogController {

    private final UpdateTimeLogService updateTimeLogService;

    @PutMapping("/{id}")
    public TimeLogResponse update(@PathVariable Long id, @Valid @RequestBody UpdateTimeLogRequest request) {
        TimeLog timeLog = updateTimeLogService.update(id, request);
        return TimeLogResponseMapper.map(timeLog);
    }

}
