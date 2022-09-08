package com.example.sfgpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.services.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeService petTypeService;

	public PetTypeFormatter(PetTypeService petTypeService) {
		super();
		this.petTypeService = petTypeService;
	}

	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	public PetType parse(String text, Locale locale) throws ParseException {

		Collection<PetType> findPetTypes = petTypeService.findAll();

		for (PetType petType : findPetTypes) {
			if (petType.getName().equals(text)) {
				return petType;
			}
		}

		throw new ParseException("type not found: " + text, 0);

	}

}
