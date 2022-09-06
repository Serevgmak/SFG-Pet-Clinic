package com.example.sfgpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Builder
@Table(name = "visits")
public class Visit extends BaseEntity {

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public Pet getPet() {
//		return pet;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setPet(Pet pet) {
//		this.pet = pet;
//	}

}
