package com.company.lms.backend.controllers.courses.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateCourseRequest {

    @NotBlank(message = "Name must be informed")
    private String name;

    private String description;

    @NotNull(message = "Enabled must be informed")
    private Boolean enabled;

}
