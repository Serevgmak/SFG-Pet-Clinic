package com.example.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.repositories.OwnerRepository;
import com.example.sfgpetclinic.repositories.PetRepository;
import com.example.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	String lastName = "Smith";
	Owner returnOwner;

	@Mock
	OwnerRepository ownerRepository;

	@Mock
	PetRepository petRepository;

	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	OwnerSDJpaService service;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(1L).lastName(lastName).build();

	}

	@Test
	void testFindAll() {

		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().id(2L).build());
		returnOwnerSet.add(Owner.builder().id(3L).build());

		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

		Set<Owner> owners = service.findAll();
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

		Owner owner = service.findById(1L);

		assertNotNull(owner);

	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();

		when(ownerRepository.save(any())).thenReturn(returnOwner);

		Owner savedOwner = service.save(ownerToSave);

		assertNotNull(savedOwner);
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {

		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

		Owner owner = service.findByLastName(lastName);

		assertEquals(lastName, owner.getLastName());

		verify(ownerRepository).findByLastName(any());
	}

}
