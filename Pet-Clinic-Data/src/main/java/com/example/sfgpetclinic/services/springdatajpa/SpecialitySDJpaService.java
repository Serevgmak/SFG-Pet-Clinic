package com.example.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.repositories.SpecialtyRepository;
import com.example.sfgpetclinic.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

	private final SpecialtyRepository specialtyRepository;

	public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialties = new HashSet<>();
		specialtyRepository.findAll().forEach(specialties::add);

		return specialties;
	}

	@Override
	public Speciality findById(Long id) {
		Optional<Speciality> optionalSpeciality = specialtyRepository.findById(id);

		if (optionalSpeciality.isPresent()) {
			return optionalSpeciality.get();
		} else {
			return null;
		}
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialtyRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);

	}

}
