package com.lab.servlet;

import com.lab.dao.ProductDAO;
import com.lab.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(id);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Edit Product</title></head>");
        out.println("<body>");
        out.println("<h1>Edit Product</h1>");
        out.println("<form action='updateProduct' method='post'>");
        out.println("<input type='hidden' name='id' value='" + product.getId() + "'>");
        out.println("Name: <input type='text' name='name' value='" + product.getName() + "'><br>");
        out.println("Category: <input type='text' name='category' value='" + product.getCategory() + "'><br>");
        out.println("Price: <input type='text' name='price' value='" + product.getPrice() + "'><br>");
        out.println("Quantity: <input type='text' name='quantity' value='" + product.getQuantity() + "'><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form>");
        out.println("<br><a href='viewProducts'>Back to List</a>");
        out.println("</body>");
        out.println("</html>");
    }
}