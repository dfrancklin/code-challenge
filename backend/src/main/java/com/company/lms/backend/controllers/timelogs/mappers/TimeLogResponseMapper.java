package com.company.lms.backend.controllers.timelogs.mappers;

import com.company.lms.backend.controllers.timelogs.dtos.TimeLogResponse;
import com.company.lms.backend.models.TimeLog;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeLogResponseMapper {

    public static TimeLogResponse map(TimeLog timeLog) {
        return TimeLogResponse.builder()
                .id(timeLog.getId())
                .description(timeLog.getDescription())
                .startedAt(timeLog.getStartedAt())
                .completedAt(timeLog.getCompletedAt())
                .createdAt(timeLog.getCreatedAt())
                .updatedAt(timeLog.getUpdatedAt())
                .category(timeLog.getCategory())
                .build();
    }
}
