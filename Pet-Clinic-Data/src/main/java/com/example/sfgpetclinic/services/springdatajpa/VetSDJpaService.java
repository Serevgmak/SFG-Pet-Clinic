package com.example.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.repositories.VetRepository;
import com.example.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);

		return vets;
	}

	@Override
	public Vet findById(Long id) {
		Optional<Vet> optionalVet = vetRepository.findById(id);

		if (optionalVet.isPresent()) {
			return optionalVet.get();
		} else {
			return null;
		}
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
