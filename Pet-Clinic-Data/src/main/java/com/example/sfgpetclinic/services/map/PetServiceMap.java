package com.example.sfgpetclinic.services.map;

import java.util.Set;

import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Pet> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Pet save(Long id, Pet object) {
		// TODO Auto-generated method stub
		return super.save(id, object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
