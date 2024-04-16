package pack;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTodo")
public class DeleteTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int todoId = Integer.parseInt(request.getParameter("id"));
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Todo todo = session.get(Todo.class, todoId);
            if (todo != null) {
                session.delete(todo);
                transaction.commit();
            }
            response.sendRedirect("todos.jsp");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
