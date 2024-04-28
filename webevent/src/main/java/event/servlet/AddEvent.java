package event.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Event;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet("/AddEvent")
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Hello</title></head><body>");
		out.println("<h3 style='padding: 10px;'>New Event</h3>");
		out.println("<form action='AddEvent' method='post'>");
		out.println("<label style='padding-left: 10px;' for='eventname'>Name:</label><input type='text' name='eventname'><br>");
		out.println("<label style='padding-left: 10px;' for='date'>Date:</label><input type='date' name='date'><br>");
		out.println("<label style='padding-left: 10px;' for='fullname'>Creator:</label><input type='text' name='fullname'><br>");
		out.println("<button style='margin-left: 10px;'>Add</button></form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String event = request.getParameter("eventname");
		String date = request.getParameter("date");
		String name = request.getParameter("fullname");
		Date parsed;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			parsed = format.parse(date);

			Event eventsL = new Event( event, parsed, name);
			
			@SuppressWarnings("unchecked")
			List<Event> events = (List<Event>) getServletContext().getAttribute("event");
			events.add( eventsL );
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("ListEvents");
		
	}

}
