import com.lab.dao.UserDAO;
import com.lab.model.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateServlet extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));

        User u = userDAO.selectUser(id);

        out.println("<form action='UpdateServlet' method='POST'>");
        out.println("<input type='hidden' name='id' value='" + u.getId() + "'>");
        out.println("Username: <input type='text' name='username' value='" + u.getUsername() + "'><br>");
        out.println("Password: <input type='text' name='password' value='" + u.getPassword() + "'><br>");
        out.println("Role: <input type='text' name='roles' value='" + u.getRoles() + "'><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");

        User user = new User(id, username, password, roles);
        userDAO.updateUser(user);

        response.sendRedirect("ViewServlet");
    }
}