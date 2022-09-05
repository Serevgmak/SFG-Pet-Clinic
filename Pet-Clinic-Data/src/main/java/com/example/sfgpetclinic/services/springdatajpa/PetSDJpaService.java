package com.example.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

	private final PetRepository petRepository;

	public PetSDJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);

		return pets;
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> optionalPet = petRepository.findById(id);

		if (optionalPet.isPresent()) {
			return optionalPet.get();
		} else {
			return null;
		}
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
