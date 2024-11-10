import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/TaskController")
public class TaskController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String description = request.getParameter("description");
            String status = request.getParameter("status");
            TaskRepository.addTask(description, status);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            String status = request.getParameter("status");
            TaskRepository.updateTask(id, description, status);
        }

        response.sendRedirect("TaskController?action=viewAll");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            TaskRepository.deleteTask(id);
            response.sendRedirect("TaskController?action=viewAll");
        } else if ("viewAll".equals(action)) {
            request.setAttribute("tasks", TaskRepository.getAllTasks());
            request.getRequestDispatcher("taskList.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Task task = TaskRepository.getTaskById(id).orElse(null);
            request.setAttribute("task", task);
            request.getRequestDispatcher("editTask.jsp").forward(request, response);
        }
    }
}
