package com.company.lms.backend.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.company.lms.backend.models.Category;

public interface CategoriesRepository extends Repository<Category, Long> {

    List<Category> findAll();

}
