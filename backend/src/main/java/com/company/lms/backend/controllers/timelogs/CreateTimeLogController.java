package com.company.lms.backend.controllers.timelogs;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.timelogs.dtos.CreateTimeLogRequest;
import com.company.lms.backend.controllers.timelogs.dtos.TimeLogResponse;
import com.company.lms.backend.controllers.timelogs.mappers.TimeLogResponseMapper;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.services.timelogs.CreateTimeLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/timelogs")
@RequiredArgsConstructor
public class CreateTimeLogController {

    private final CreateTimeLogService createTimeLogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TimeLogResponse create(@Valid @RequestBody CreateTimeLogRequest request) {
        TimeLog timeLog = createTimeLogService.create(request);
        return TimeLogResponseMapper.map(timeLog);
    }

}
