package com.example.project.models;

import com.example.project.data.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Integer> {
    Page findBySlug(String slug);

    Page findBySlugAndIdNot(String slug , int id);

    List<Page> findAllByOrderBySortingAsc();
}
