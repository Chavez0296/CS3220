package event.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Event;

@WebServlet(urlPatterns="/ListEvents", loadOnStartup=1)
public class ListEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListEvents() {
		super() ;
	}

	public void init( ServletConfig config) throws ServletException {
		super.init( config );
	
		List<Event> events = new ArrayList<>();
		
		Date date = new Date();
		
		date.setTime(1676399999590L);
		
		events.add(new Event("Room 19 Valentine Party", date, "Amy Frank"));
		events.add(new Event("Room 19 Kindergarten Graduation", date, "Amy Frank"));
		
		
		
		getServletContext().setAttribute("event",events);
		
	}

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	
		SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
		
		
		List<Event> events = (List<Event>) getServletContext().getAttribute("event");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Hello</title></head><body>");
		out.println("<a href='AddEvent'>New Event</a>");
		out.println("<table style='border: 1px solid black; border-collapse: collapse;'>");
		out.println("<tr><th style='border: 1px solid black; padding: 10px;'>Event</th><th style='border: 1px solid black; padding: 10px;'>Date</th><th style='border: 1px solid black; padding: 10px;'>Created By</th></tr>");
		for( Event eventsL : events)
		{
			out.println("<tr>");
			out.println("<td style='border: 1px solid black; padding: 10px;'>"+ eventsL.getEvent()+"</td>");
			out.println("<td style='border: 1px solid black; padding: 10px;'>"+ dateForm.format(eventsL.getDate())+"</td>");
			out.println("<td style='border: 1px solid black; padding: 10px;'>"+eventsL.getName()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		
		//save
		getServletContext().setAttribute("event", events);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
