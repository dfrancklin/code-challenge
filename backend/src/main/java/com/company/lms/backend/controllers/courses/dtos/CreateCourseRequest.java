package com.company.lms.backend.controllers.courses.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateCourseRequest {

    @NotBlank(message = "Name must be informed")
    private String name;

    private String description;

}
