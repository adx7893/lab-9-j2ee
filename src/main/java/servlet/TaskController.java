package servlet;

import model.TaskRepository;
import model.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private TaskRepository taskRepository;

	    @Override
	    public void init() throws ServletException {
	        taskRepository = new TaskRepository();
	    }  

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if ("delete".equals(action)) {
	            int id = Integer.parseInt(request.getParameter("id"));
	            taskRepository.deleteTask(id);
	        }
	        request.setAttribute("tasks", taskRepository.getAllTasks());
	        request.getRequestDispatcher("view/taskList.jsp").forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if ("add".equals(action)) {
	            String description = request.getParameter("description");
	            String status = request.getParameter("status");

	            // Validate input
	            if (description == null || description.trim().isEmpty()) {
	                // If description is invalid, set an error message and forward to addTask.jsp
	                request.setAttribute("errorMessage", "Task description is required.");
	                request.getRequestDispatcher("addTask.jsp").forward(request, response);
	                return;
	            }

	            // Add the task if validation passed
	            taskRepository.addTask(description, status);
	            response.sendRedirect("taskList.jsp");
	        }
	    }
}
