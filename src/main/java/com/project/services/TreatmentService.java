package com.project.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.dao.TreatmentRepository;
import com.project.model.Treatment;

@Service
@Transactional
public class TreatmentService {

	private final TreatmentRepository treatmentRepository;

	public TreatmentService(TreatmentRepository treatmentRepository) {
		this.treatmentRepository = treatmentRepository;
	}
	
	public List<Treatment> findAll() {
		List<Treatment> treatments = new ArrayList<>();
		
		for (Treatment treatment : treatmentRepository.findAll()) {
			treatments.add(treatment);
		}
		
		return treatments;
	}
	
	public Treatment findTreatment (int id) {
		return treatmentRepository.findOne(id);
	}
	
	public void save(Treatment treatment) {
		treatmentRepository.save(treatment);
	}
	
	public void delete(int id) {
		treatmentRepository.delete(id);
	}
	
}
