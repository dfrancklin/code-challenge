package com.company.lms.backend.services.timelogs;

import org.springframework.stereotype.Service;

import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.repositories.TimeLogsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteTimeLogService {

    private final TimeLogsRepository repository;

    private final LoadTimeLogByIdService loadTimeLogByIdService;

    public void delete(Long id) {
        TimeLog timeLog = loadTimeLogByIdService.load(id);

        repository.delete(timeLog);
    }

}
