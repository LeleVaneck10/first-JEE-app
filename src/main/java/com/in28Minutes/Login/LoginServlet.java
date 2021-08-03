package com.in28Minutes.Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28Minutes.todo.TodoService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	
	private LoginService userValLoginService = new LoginService();
	private TodoService todoService = new TodoService(); 
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
 
}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean isUserValid = userValLoginService.isUserValid(name, password);  
		
		if (isUserValid) {
			request.getSession().setAttribute("name", name);
		response.sendRedirect("/list-todos.do");
		} 
		else {
			request.setAttribute("errorMessage", "Invalid Credential");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);  
		}
	

}
}