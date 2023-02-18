package com.company.lms.backend.services.timelogs;

import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.timelogs.dtos.UpdateTimeLogRequest;
import com.company.lms.backend.models.Category;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.repositories.TimeLogsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateTimeLogService {

    private final TimeLogsRepository repository;

    private final LoadTimeLogByIdService loadTimeLogByIdService;

    public TimeLog update(Long id, UpdateTimeLogRequest request) {
        TimeLog timeLog = loadTimeLogByIdService.load(id);
        Category category = Category.builder().id(request.getCategoryId()).build();

        timeLog.setDescription(request.getDescription());
        timeLog.setStartedAt(request.getStartedAt());
        timeLog.setCompletedAt(request.getCompletedAt());
        timeLog.setCategory(category);

        return repository.save(timeLog);
    }

}
