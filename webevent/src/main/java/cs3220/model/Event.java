package cs3220.model;
import java.util.*;
public class Event {
	private String name;
	private String event;
	private Date date;
	
	public Event(String event, Date date, String name) {
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
	public Date getDate()
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
	public void setDate(Date date)
	{
		this.date = date;
	}
}
