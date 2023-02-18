package com.company.lms.backend.controllers.timelogs;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.timelogs.dtos.TimeLogResponse;
import com.company.lms.backend.controllers.timelogs.mappers.TimeLogResponseMapper;
import com.company.lms.backend.services.timelogs.LoadAllTimeLogsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class LoadAllTimeLogsController {

    private final LoadAllTimeLogsService loadAllTimeLogsService;

    @GetMapping("/{enrollmentId}/timelogs")
    public Page<TimeLogResponse> load(@PathVariable Long enrollmentId, @RequestParam(required = false) Integer page) {
        page = page == null ? 0 : page;

        return loadAllTimeLogsService.load(enrollmentId, page).map(TimeLogResponseMapper::map);
    }

}
