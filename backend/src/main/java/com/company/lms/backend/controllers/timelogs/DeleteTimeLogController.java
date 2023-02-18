package com.company.lms.backend.controllers.timelogs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.services.timelogs.DeleteTimeLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/timelogs")
@RequiredArgsConstructor
public class DeleteTimeLogController {

    private final DeleteTimeLogService deleteTimeLogService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteTimeLogService.delete(id);
    }

}
