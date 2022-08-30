package com.example.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		Owner owner1 = new Owner();
		// owner1.setId(1L);
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		// owner2.setId(2L);
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenann");
		ownerService.save(owner2);

		System.out.println("Loaded owners...");

		Vet vet1 = new Vet();
		// vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		// vet2.setId(2L);
		vet2.setFirstName("Jessie");
		vet2.setLastName("Portman");
		vetService.save(vet2);

		System.out.println("Loaded vets...");

	}

}
