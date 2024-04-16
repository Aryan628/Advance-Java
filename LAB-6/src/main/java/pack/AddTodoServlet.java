package pack;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTodo")
public class AddTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");

        Todo newTodo = new Todo();
        newTodo.setDescription(description);
        newTodo.setComplete(false);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(newTodo);
            transaction.commit();
            response.sendRedirect("todos.jsp");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
