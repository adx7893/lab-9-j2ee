<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
</head>
<body>
<h2>Add Task</h2>

    <!-- Display error message if it exists -->
    <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
    <% if (errorMessage != null) { %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>

    <form action="/TaskController" method="post">
        <label for="description">Description:</label>
        <input type="text" name="description" required><br><br>

        <label for="status">Status:</label>
        <select name="status">
            <option value="Pending">Pending</option>
            <option value="Completed">Completed</option>
        </select><br><br>

        <button type="submit" name="action" value="add">Add Task</button>
    </form>
    <br>
    <a href="taskList.jsp">Back to Task List</a>
</body>
</html>