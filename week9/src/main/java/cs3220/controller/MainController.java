package cs3220.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs3220.DataStore;
import cs3220.model.Event;
import cs3220.model.Item;


@Controller
public class MainController {
	
	private final DataStore dataStore;
	
	public MainController(DataStore dataStore)
	{
		this.dataStore = dataStore;
	}
	 
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("events", dataStore.getEvents());
		return "index";
	}
	
	@RequestMapping("/view/{id}")
	public String viewEvent(@PathVariable int id, Model model)
	{
		model.addAttribute("event", dataStore.getEvent(id));
		return "view";
	}
	
	@GetMapping("/signUp/{eventId}/{itemId}")
	public String signUp(@PathVariable int eventId, @PathVariable int itemId, Model model){
		model.addAttribute("eventId", eventId);
		model.addAttribute("itemId", itemId);
		return "signUp";
	}
	
	@PostMapping("/signUp/{eventId}/{itemId}")
	public String signUp(@PathVariable int eventId, @PathVariable int itemId, String person){
		dataStore.getEvent(eventId).getItems().get(itemId).setPerson(person);
		return "redirect:/view/{eventId}";
	}

	@GetMapping("/addItem/{eventId}")
    public String showAddItemForm(@PathVariable int eventId, Model model) {
        model.addAttribute("event", dataStore.getEvent(eventId));
        return "addItem";
    }

	@PostMapping("/addItem/{eventId}")
	public String addItem(@PathVariable int eventId, @RequestParam String itemName, @RequestParam int quantity) {
	    Event event = dataStore.getEvent(eventId);
	    for (int i = 0; i < quantity; i++) {
	        event.getItems().add(new Item(itemName, 1)); // Assuming each item has a default quantity of 1
	    }
	    return "redirect:/view/{eventId}";
	}
	
	@GetMapping("/deleteItem/{eventId}/{itemId}")
    public String deleteItem(@PathVariable int eventId, @PathVariable int itemId) {
        Event event = dataStore.getEvent(eventId);
        event.getItems().removeIf(item -> item.getId() == itemId);
        return "redirect:/view/{eventId}";
    }
	
	@GetMapping("/addEvent")
	public String showAddEventForm() {
		return "addEvent";
	}
	
	@PostMapping("/addEvent")
	public String addEvent(Event event)
	{
		dataStore.getEvents().add(event);
		return "redirect:/";
	}
	
	@GetMapping("/editEvent/{id}")
	public String editEvent(@PathVariable int id, Model model)
	{
		model.addAttribute("event", dataStore.getEvent(id));
		return "editEvent";
	}
	
	@PostMapping("/editEvent/{id}")
	public String editEvent(@PathVariable int id, Event newEvent)
	{
		Event event = dataStore.getEvent(id);
		event.setName(newEvent.getName());
		event.setEvent(newEvent.getEvent());
		event.setDate(newEvent.getDate());
		return "redirect:/";
	}
	
}
