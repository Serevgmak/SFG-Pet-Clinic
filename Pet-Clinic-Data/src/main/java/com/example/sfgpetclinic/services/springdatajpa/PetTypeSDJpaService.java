package com.example.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import com.example.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> types = new HashSet<>();
		petTypeRepository.findAll().forEach(types::add);

		return types;
	}

	@Override
	public PetType findById(Long id) {
		Optional<PetType> optionalPetType = petTypeRepository.findById(id);

		if (optionalPetType.isPresent()) {
			return optionalPetType.get();
		} else {
			return null;
		}
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
