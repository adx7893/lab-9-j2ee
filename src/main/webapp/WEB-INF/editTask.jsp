<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Task task = (Task) request.getAttribute("task");
%>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<h2>Edit Task</h2>
<form action="TaskController" method="post">
    <input type="hidden" name="id" value="<%= task.getId() %>">
    <label for="description">Description:</label>
    <input type="text" name="description" id="description" value="<%= task.getDescription() %>" required><br>
    <label for="status">Status:</label>
    <select name="status" id="status">
        <option value="Pending" <%= "Pending".equals(task.getStatus()) ? "selected" : "" %>>Pending</option>
        <option value="Completed" <%= "Completed".equals(task.getStatus()) ? "selected" : "" %>>Completed</option>
    </select><br>
    <button type="submit" name="action" value="update">Update Task</button>
</form>
</body>
</html>
