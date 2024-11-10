<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Task</title>
</head>
<body>
<h2>Add New Task</h2>
<form action="TaskController" method="post">
    <label for="description">Description:</label>
    <input type="text" name="description" id="description" required><br>
    <label for="status">Status:</label>
    <select name="status" id="status">
        <option value="Pending">Pending</option>
        <option value="Completed">Completed</option>
    </select><br>
    <button type="submit" name="action" value="add">Add Task</button>
</form>
</body>
</html>
