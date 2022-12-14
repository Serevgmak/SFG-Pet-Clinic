package com.example.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.repositories.OwnerRepository;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.repositories.PetTypeRepository;
import com.example.sfgpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
//@Primary
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {

		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);

		return owners;
	}

	@Override
	public Owner findById(Long id) {

		Optional<Owner> optionalOwner = ownerRepository.findById(id);

		if (optionalOwner.isPresent()) {
			return optionalOwner.get();
		} else {
			return null;
		}
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		System.out.println("Saving owner with OwnerSDJpaService");
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findAllByLastNameLike(lastName);
	}

}
