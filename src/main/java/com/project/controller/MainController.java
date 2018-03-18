package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Treatment;
import com.project.services.TreatmentService;

@Controller
public class MainController {	
	
	@Autowired
	private TreatmentService treatmentService;
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-treatments")
	public String allTreatments(HttpServletRequest request) {
		request.setAttribute("treatments", treatmentService.findAll());
		request.setAttribute("mode", "MODE_TREATMENTS");
		return "index";
	}
	
	@GetMapping("/new-treatment")
	public String newTreatment(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-treatment")
	public String saveTreatment(@ModelAttribute Treatment treatment, BindingResult bindingResult, HttpServletRequest request) {
		treatmentService.save(treatment);
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@GetMapping("/update-treatment")
	public String updateTreatment(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("treatment", treatmentService.findTreatment(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-treatment")
	public String deleteTreatment(@RequestParam int id, HttpServletRequest request) {
		treatmentService.delete(id);
		request.setAttribute("treatments", treatmentService.findAll());
		request.setAttribute("mode", "MODE_TREATMENTS");
		return "index";
	}
}
