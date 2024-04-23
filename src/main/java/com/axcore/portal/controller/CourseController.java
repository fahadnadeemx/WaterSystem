package com.axcore.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axcore.portal.entity.Course;
import com.axcore.portal.service.CourseServiceImpl;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseService;

	@GetMapping("/")
	public String getAllCourses(Model model) {
		model.addAttribute("courses", courseService.getAllCourses());
		return "pages/course-list"; // Assuming you have a Thymeleaf template named "course-list.html"
	}

	@GetMapping("/add")
	public String showAddCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "pages/course-list"; // Thymeleaf template for adding a student
	}

	@PostMapping("/")
	public String createCourse(@ModelAttribute Course course) {
		courseService.saveOrUpdateCourse(course);
		return "redirect:/courses/";
	}

	@GetMapping("/{id}")
	public String getCourseById(@PathVariable("id") Long id, Model model) {

		Course course = courseService.getCourseById(id);
		if (course == null) {
			return "redirect:/courses/";
		}
		model.addAttribute("course", course);
		return "pages/course-details"; // Assuming you have a Thymeleaf template named "course-details.html"
	}

	@GetMapping("/{id}/edit")
	public String showUpdateCourseForm(@PathVariable("id") Long id, Model model) {
		Course course = courseService.getCourseById(id);
		if (course == null) {
			return "redirect:/courses/";
		}
		model.addAttribute("course", course);
		return "update-course"; // Assuming you have a Thymeleaf template named "teacher-edit.html" for editing
								// teacher details
	}

	@PostMapping("/{id}")
	public String updateCourse(@PathVariable("id") Long id, @ModelAttribute Course course) {
		course.setCourseId(id);
		courseService.saveOrUpdateCourse(course);
		return "redirect:/courses/";
	}

	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
		return "redirect:/courses/";
	}
}
