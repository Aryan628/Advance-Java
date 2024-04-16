<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="pack.Todo" %>
<%@ page import="pack.HibernateUtil" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <style>
        body, html {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            margin: 0;
            padding: 0;
            height: 100%; /* Ensures the page takes at least the full height */
            display: flex;
            justify-content: center;
            align-items: flex-start; /* Align to top instead of center */
            overflow: auto; /* Allows scrolling */
        }
        .container {
            width: 600px;
            background: white;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            margin-top: 20px; /* Adds some space on the top */
            margin-bottom: 20px; /* Adds some space on the bottom */
        }
        h1 {
            color: #007bff;
            text-align: center;
        }
        form {
            display: flex;
            margin-top: 20px;
        }
        input[type="text"] {
            flex: 1;
            padding: 10px;
            margin-right: 10px;
            border: 2px solid #ccc;
            border-radius: 4px;
            outline: none;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus {
            border-color: #007bff;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .todo-item {
            background-color: #f8f9fa;
            border-left: 5px solid #007bff;
            margin-top: 10px;
            padding: 10px;
            border-radius: 4px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .completed {
            text-decoration: line-through;
            color: #6c757d;
        }
        .actions {
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Todo List</h1>
        <form action="addTodo" method="post">
            <input type="text" name="description" required placeholder="Add a new todo...">
            <input type="submit" value="Add">
        </form>
        <% 
        List<Todo> todos = null;
        try (Session ession = HibernateUtil.getSessionFactory().openSession()) {
            todos = ession.createQuery("from Todo", Todo.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (todos != null) {
            for (Todo todo : todos) {
                out.print("<div class='todo-item'><p class='text" + (todo.isComplete() ? " completed'" : "'") + ">" + todo.getDescription() + "</p><div class='actions'>");
                if (!todo.isComplete()) {
                    out.print("<form action='completeTodo' method='post'><input type='hidden' name='id' value='" + todo.getId() + "'><input type='submit' value='Complete'></form> ");
                }
                out.print("<form action='deleteTodo' method='post'><input type='hidden' name='id' value='" + todo.getId() + "'><input type='submit' value='Delete'></form></div></div>");
            }
        }
        %>
    </div>
</body>
</html>
