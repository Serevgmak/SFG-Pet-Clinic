package com.example.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/", "/index", "/index.html", "/owners.html" })
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());

		return "owners/index";
	}

	@RequestMapping("/find")
	public String findOwners() {
		return "notimplemented";
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable Long ownerId) {

		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
		modelAndView.addObject(ownerService.findById(ownerId));
		return modelAndView;

	}

}
