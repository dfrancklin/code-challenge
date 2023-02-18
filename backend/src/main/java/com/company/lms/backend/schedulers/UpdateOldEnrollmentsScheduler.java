package com.company.lms.backend.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.company.lms.backend.services.enrollments.UpdateOldEnrollmentsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateOldEnrollmentsScheduler {

    private final UpdateOldEnrollmentsService updateOldEnrollmentsService;

    @Scheduled(cron = "${update.cron.schedule}")
    public void update() {
        try {
            log.info("Starting to process old enrollments");

            updateOldEnrollmentsService.update();

            log.info("Finished to process old enrollments");
        } catch (Exception e) {
            log.error("An error occurred while trying to process old enrollments. Error: {}", e.getMessage());
            log.debug("Error stack:", e);
        }
    }

}
