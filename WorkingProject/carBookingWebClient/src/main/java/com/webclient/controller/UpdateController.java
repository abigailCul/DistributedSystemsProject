package com.webclient.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webclient.http.httpRequests;
import com.webclient.models.Booking;

@Controller
public class UpdateController {

	// Add a new booking
	@RequestMapping(value = "/addAccount", method = RequestMethod.GET)
	public String addAccountGET(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "addAccount";
	}

	// When request is submitted
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addAccountPOST(@Valid @ModelAttribute("booking") Booking booking, Model model) {

		return "index";
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/viewAccount", method = RequestMethod.GET)
	public String viewAccountGET(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "viewAccount";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/viewAccount", method = RequestMethod.POST)
	public String viewAccountPOST(@Valid @ModelAttribute("booking") Booking booking, Model model) {

		return "index";
	}

	// When the user selects new User (Get Request)
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
	public String deleteAccountGET(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "deleteAccount";
	}

	// When the user submits the form (Post Request)
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
	public String deleteAccountPOST(@Valid @ModelAttribute("booking") Booking booking, Model model) {

		return "index";
	}

	// update user get request
	@RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
	public String updateAccountGET(Model model) {
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		return "updateAccount";
	}

	// send in the update
	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	public String updateAccountPOST(@Valid @ModelAttribute("booking") Booking booking, Model model) {
		
		new httpRequests().updateBooking(booking);
		
		return "index";
	}
}
