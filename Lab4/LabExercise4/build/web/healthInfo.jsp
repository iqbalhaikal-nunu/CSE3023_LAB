<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Health Information</title></head>
<body>
    <jsp:include page="header.jsp" />

    <div class="card">
        <h1>BMI Classification</h1>
        <table style="width: 100%; border-collapse: collapse; margin-top: 20px;">
            <tr style="background-color: #6f42c1; color: white;">
                <th style="padding: 12px; text-align: left;">Category</th>
                <th style="padding: 12px; text-align: left;">BMI Range</th>
            </tr>
            <%
                ArrayList<String[]> levels = new ArrayList<>();
                levels.add(new String[]{"Underweight", "Below 18.5"});
                levels.add(new String[]{"Normal", "18.5 - 25.0"});
                levels.add(new String[]{"Overweight", "Above 25.0"});

                for(String[] row : levels) {
            %>
            <tr style="border-bottom: 1px solid #eee;">
                <td style="padding: 12px;"><%= row[0] %></td>
                <td style="padding: 12px;"><%= row[1] %></td>
            </tr>
            <% } %>
        </table>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>