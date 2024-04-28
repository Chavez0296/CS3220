package cs3220.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import cs3220.model.Item;
import org.springframework.format.annotation.DateTimeFormat;

public class Event {
	private static int idSeed = 1;
	
	private int id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String event;
	
	private List<Item> items;
	public Event(String event, LocalDate date, String name) {
		id = idSeed++;
		this.event = event;
		this.date = date;
		this.name = name;
		this.items = new ArrayList<Item>();
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent()
	{
		return event;
	}
	public String getName()
	{
		return name;
	}
	public LocalDate getDate()
	{
		return date;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setEvent(String event)
	{
		this.event = event;
	}
	public void setDate(LocalDate date)
	{
		this.date = date;
	}
	
}
