package com.webclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// Back to index file main file
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
