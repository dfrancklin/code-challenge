package com.company.lms.backend.controllers.categories;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.models.Category;
import com.company.lms.backend.services.categories.LoadAllCategoriesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class LoadAllCategoriesController {

    private final LoadAllCategoriesService loadAllCategoriesService;

    @GetMapping
    public List<Category> load() {
        return loadAllCategoriesService.load();
    }

}
