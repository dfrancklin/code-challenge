package com.company.lms.backend.services.categories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.lms.backend.models.Category;
import com.company.lms.backend.repositories.CategoriesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadAllCategoriesService {

    private final CategoriesRepository repository;

    public List<Category> load() {
        return repository.findAll();
    }

}
