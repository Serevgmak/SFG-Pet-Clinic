package com.example.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Speciality;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.SpecialityService;
import com.example.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0) {
			loadData();

		}

	}

	private void loadData() {
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		Speciality radiology = new Speciality();
		radiology.setDescriprion("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		radiology.setDescriprion("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		radiology.setDescriprion("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		ownerService.save(owner1);
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231231234");
		Pet fionasCat = new Pet();
		fionasCat.setName("Just Cat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setPetType(savedCatPetType);
		owner2.getPets().add(fionasCat);
		ownerService.save(owner2);
		System.out.println("Loaded Owners....");
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialties().add(savedSurgery);

		vetService.save(vet2);

//		Owner owner1 = new Owner();
//		// owner1.setId(1L);
//		owner1.setFirstName("Michael");
//		owner1.setLastName("Weston");
//		owner1.setAddress("123 Brickerel");
//		owner1.setCity("Miami");
//		owner1.setTelephone("123123123");
//
//		Pet mikesPet = new Pet();
//		// mikesPet.setPetType(savedDogPetType);
//		mikesPet.setPetType(dog);
//		mikesPet.setOwner(owner1);
//		mikesPet.setBirthDate(LocalDate.now());
//		mikesPet.setName("Rosco");
//		owner1.getPets().add(mikesPet);
//		ownerService.save(owner1);
//
//		Owner owner2 = new Owner();
//		// owner2.setId(2L);
//		owner2.setFirstName("Fiona");
//		owner2.setLastName("Glenann");
//		owner2.setAddress("123 Brickerel");
//		owner2.setCity("Miami");
//		owner2.setTelephone("123123123123");
//
//		Pet fionasCat = new Pet();
//		// fionasCat.setPetType(savedCatPetType);
//		fionasCat.setPetType(cat);
//		fionasCat.setOwner(owner2);
//		fionasCat.setBirthDate(LocalDate.now());
//		fionasCat.setName("Baron");
//		owner2.getPets().add(fionasCat);
//		ownerService.save(owner2);
//
//		System.out.println("Loaded owners...");
//
//		Vet vet1 = new Vet();
//		// vet1.setId(1L);
//		vet1.setFirstName("Sam");
//		vet1.setLastName("Axe");
//		vetService.save(vet1);
//		vet1.getSpecialties().add(savedRadiology);
//
//		Vet vet2 = new Vet();
//		// vet2.setId(2L);
//		vet2.setFirstName("Jessie");
//		vet2.setLastName("Portman");
//		vetService.save(vet2);
//		vet2.getSpecialties().add(savedSurgery);

		System.out.println("Loaded vets...");
	}

}
