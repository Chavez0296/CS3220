package com.example.demo;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import week8.model.Event;
@Controller
public class IndexController {
	
	private List<Event> events;
	
	public IndexController()
	{
		events = new ArrayList<Event>();
		events.add(new Event("Event1", LocalDate.now(),"Him"));
		events.add(new Event("Event2", LocalDate.now().plusDays(5),"Her"));
		
	}
	
	@GetMapping("/")
	public String listEvents(Model model)
	{
		model.addAttribute("events",events);
		return "index";
	}
	
	@GetMapping("/addEvent")
	public String showAddEventForm() {
		
		return "addEvent";
	}
	@PostMapping("/addEvent")
	public String addEvent(@ModelAttribute Event event)
	{
		events.add(event);
		return "redirect:/";
		
	}
}
