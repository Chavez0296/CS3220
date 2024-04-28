package week8.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Event {
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private String event;
	public Event(String event, LocalDate date, String name) {
		this.event = event;
		this.date = date;
		this.name = name;
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
