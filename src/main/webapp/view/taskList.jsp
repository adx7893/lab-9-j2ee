<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Task" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>
</head>
<body>
<h2>Task List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <%
            List<Task> tasks = (List<Task>) request.getAttribute("tasks");
            if (tasks != null) {
                for (Task task : tasks) {
        %>
        <tr>
            <td><%= task.getId() %></td>
            <td><%= task.getDescription() %></td>
            <td><%= task.getStatus() %></td>
            <td><a href="TaskController?action=delete&id=<%= task.getId() %>">Delete</a></td>
        </tr>
        <% }} %>
    </table>
    <br>
    <a href="../view/addTask.jsp">Add New Task</a>
</body>
</html>