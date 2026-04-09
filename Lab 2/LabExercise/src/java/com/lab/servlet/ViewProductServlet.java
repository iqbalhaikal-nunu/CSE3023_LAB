package com.lab.servlet;

import com.lab.dao.ProductDAO;
import com.lab.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();
        
        out.println("<html>");
        out.println("<head><title>Product List</title></head>");
        out.println("<body>");
        out.println("<h1>Product List</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Quantity</th><th>Actions</th></tr>");
        
        for (Product p : products) {
            out.println("<tr>");
            out.println("<td>" + p.getId() + "</td>");
            out.println("<td>" + p.getName() + "</td>");
            out.println("<td>" + p.getCategory() + "</td>");
            out.println("<td>" + p.getPrice() + "</td>");
            out.println("<td>" + p.getQuantity() + "</td>");
            out.println("<td>");
            out.println("<a href='editProduct?id=" + p.getId() + "'>Edit</a> | ");
            out.println("<a href='deleteProduct?id=" + p.getId() + "' onclick='return confirm(\"Are you sure?\")'>Delete</a>");
            out.println("</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        out.println("<br><a href='add_product.html'>Add New Product</a>");
        out.println("<br><a href='index.html'>Home</a>");
        out.println("</body>");
        out.println("</html>");
    }
}