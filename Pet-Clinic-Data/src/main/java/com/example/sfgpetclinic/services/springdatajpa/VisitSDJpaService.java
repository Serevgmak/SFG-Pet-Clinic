package com.example.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Visit;
import com.example.sfgpetclinic.repositories.VisitRepository;
import com.example.sfgpetclinic.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

	private final VisitRepository visitRepository;

	public VisitSDJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);

		return visits;
	}

	@Override
	public Visit findById(Long id) {
		Optional<Visit> optionalVisit = visitRepository.findById(id);

		if (optionalVisit.isPresent()) {
			return optionalVisit.get();
		} else {
			return null;
		}
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {

		visitRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);

	}

}
