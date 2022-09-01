package com.example.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends Person {

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "telephone")
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

	public Owner(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getTelephone() {
		return telephone;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
