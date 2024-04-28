package cs3220;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cs3220.model.Event;
import cs3220.model.Item;
@Component
public class DataStore {
	private List<Event> events;
	
	
	public DataStore()
	{
		events = new ArrayList<Event>();
		events.add(new Event("Event 1", LocalDate.now(),"DataStore"));
		events.add(new Event("Event 2", LocalDate.now().plusDays(4), "DataStore 2"));
		events.get(0).getItems().add(new Item("Donuts", 10));
	}
	public Event getEvent(int id)
	{
		for(Event event : events)
			if(event.getId() == id) 
				return event;
		return null;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}
