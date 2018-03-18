package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.services.TreatmentService;

@RestController
public class SampleRestController {
	
	@Autowired
	private TreatmentService treatmentService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
//	@GetMapping("/all-treatments")
//	public String allTreatments() {
//		return treatmentService.findAll().toString();
//	}
	
}
