package com.example.sfgpetclinic.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController controller;

	Set<Owner> owners;
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {

		owners = new HashSet<>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

	}

	@Test
	void testListOwners() throws Exception {

		when(ownerService.findAll()).thenReturn(owners);

		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owners/index"));
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("notimplemented"));
	}

	@Test
	void displayOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

		mockMvc.perform(get("/owners/123")).andExpect(status().isOk()).andExpect(view().name("owners/ownerDetails"));
		// .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
	}

}
