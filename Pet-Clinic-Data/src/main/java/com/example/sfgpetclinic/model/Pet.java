package com.example.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();

	@Builder
	public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
		super(id);
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
		if (visits != null && visits.size() > 0) {
			this.visits = visits;
		}
	}

//	public Pet(PetType petType, Owner owner, LocalDate birthDate) {
//		super();
//		this.petType = petType;
//		this.owner = owner;
//		this.birthDate = birthDate;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public PetType getPetType() {
//		return petType;
//	}
//
//	public void setPetType(PetType petType) {
//		this.petType = petType;
//	}
//
//	public Owner getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Owner owner) {
//		this.owner = owner;
//	}
//
//	public LocalDate getBirthDate() {
//		return birthDate;
//	}
//
//	public void setBirthDate(LocalDate birthDate) {
//		this.birthDate = birthDate;
//	}
//
//	public Set<Visit> getVisits() {
//		return visits;
//	}
//
//	public void setVisits(Set<Visit> visits) {
//		this.visits = visits;
//	}

}
