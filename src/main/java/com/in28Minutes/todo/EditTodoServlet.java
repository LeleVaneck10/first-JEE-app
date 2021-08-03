package com.in28Minutes.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28Minutes.todo.TodoService;

@WebServlet(urlPatterns = "/edit-todo.do")
public class EditTodoServlet extends HttpServlet{
	
	
	private TodoService todoService = new TodoService(); 
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		String id = request.getParameter("id");
		Integer ID = Integer.parseInt(id);
		Todo newTodo = todoService.editTodo(ID);
		
		request.setAttribute("id", ID);
		
		request.getRequestDispatcher("/WEB-INF/views/edit-todo.jsp").forward(request, response);
		
}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		String todo = request.getParameter("todo");
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		Integer ID = Integer.parseInt(id);
		Todo newTodo = todoService.editTodo(ID);
		
		newTodo.setName(todo);
		newTodo.setCategory(category);
				
		response.sendRedirect("/list-todos.do");
 
}
}