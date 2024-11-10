<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task List</title>
</head>
<body>
    <h1>Task List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.id}</td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>
                    <a href="TaskController?action=edit&id=${task.id}">Edit</a>
                    <a href="TaskController?action=delete&id=${task.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addTask.jsp">Add New Task</a>
</body>
</html>
