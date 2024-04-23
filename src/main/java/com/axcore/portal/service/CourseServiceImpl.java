package com.axcore.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axcore.portal.entity.Course;
import com.axcore.portal.repository.CourseRepository;

@Service
public class CourseServiceImpl {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Course getCourseById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	public Course saveOrUpdateCourse(Course course) {
		return courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}
