package com.example.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

	private Set<Specialty> specialities;

	public Vet(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Vet() {
		// TODO Auto-generated constructor stub
	}

	public Set<Specialty> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Specialty> specialities) {
		this.specialities = specialities;
	}

}
