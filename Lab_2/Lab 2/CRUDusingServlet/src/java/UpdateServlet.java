import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateServlet extends HttpServlet {

    // 🔹 SHOW FORM (GET)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CSE3023", "root", ""
);

            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<html><body>");
                out.println("<h2>Update User</h2>");

                out.println("<form action='UpdateServlet' method='POST'>");

                out.println("<input type='hidden' name='id' value='" + rs.getInt("id") + "'>");

                out.println("Username: <input type='text' name='username' value='" + rs.getString("username") + "'><br><br>");
                out.println("Password: <input type='text' name='password' value='" + rs.getString("password") + "'><br><br>");
                out.println("Role: <input type='text' name='roles' value='" + rs.getString("roles") + "'><br><br>");

                out.println("<input type='submit' value='Update'>");
                out.println("</form>");

                out.println("</body></html>");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE DATA (POST)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/CSE3023", "root", ""
            );

            String sql = "UPDATE users SET username=?, password=?, roles=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, roles);
            ps.setInt(4, id);

            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("ViewServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}