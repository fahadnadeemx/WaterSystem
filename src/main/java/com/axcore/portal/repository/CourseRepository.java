package com.axcore.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axcore.portal.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add custom query methods if needed
}
