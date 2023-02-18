package com.company.lms.backend.controllers.courses.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatorResponse {

    private Long id;

    private String firstName;

    private String lastName;

}
