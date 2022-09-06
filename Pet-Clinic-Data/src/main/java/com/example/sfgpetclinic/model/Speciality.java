package com.example.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "specialties")
public class Speciality extends BaseEntity {

	@Column(name = "description")
	private String descriprion;

//	public String getDescriprion() {
//		return descriprion;
//	}
//
//	public void setDescriprion(String descriprion) {
//		this.descriprion = descriprion;
//	}

}
