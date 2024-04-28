package edu.csula.cs3220stu42.Web.servlet;

import cs3220.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("John Doe","jdoe","abcd"));
		users.add(new User("Andrew Doe", "adoe", "password"));
		
		getServletContext().setAttribute("users", users);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) getServletContext().getAttribute("users");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Hello</title></head><body>");
		out.println("<form action='HelloServlet' method='post'>");
		out.println("<label for='username'>Username:</label><input type='text' name='username'><br>");
		out.println("<label for='password'>Password:</label><input type='text' name='password'><br>");
		out.println("<button>Login</button></form>");
		out.println("</body></html>");
		
		getServletContext().setAttribute("users", users);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String username_ = request.getParameter("username");
		 String password_ = request.getParameter("password");
		 
		 @SuppressWarnings("unchecked")
		List<User> users = (List<User>) getServletContext().getAttribute("users");
		 
		 for(User usersL : users)
		 {
			 if(usersL.getUsername().equals(username_) && usersL.getPassword().equals(password_))
			 {
				 request.getSession().setAttribute("user", usersL);
				 response.sendRedirect("Members");
				 return;
			 }
		 }
		 response.sendRedirect("HelloServlet");

	}
}
