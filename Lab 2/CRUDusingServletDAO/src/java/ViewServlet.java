import com.lab.dao.UserDAO;
import com.lab.model.User;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        List<User> list = userDAO.selectAllUsers();

        out.println("<h2>User List</h2>");
        out.println("<table border='1'>");

        for (User u : list) {
            out.println("<tr>");
            out.println("<td>" + u.getId() + "</td>");
            out.println("<td>" + u.getUsername() + "</td>");
            out.println("<td>" + u.getPassword() + "</td>");
            out.println("<td>" + u.getRoles() + "</td>");
            out.println("<td>");
            out.println("<a href='UpdateServlet?id=" + u.getId() + "'>Edit</a> | ");
            out.println("<a href='DeleteServlet?id=" + u.getId() + "'>Delete</a>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
    }
}