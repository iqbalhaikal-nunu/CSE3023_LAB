<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>BMI Result</title></head>
<body>
    <jsp:include page="header.jsp" />
    
    <%
        
        String bmiValStr = request.getParameter("bmiValue") ;
        
        Double bmiValueDbl = Double.parseDouble(bmiValStr);
    
    
    %>

    <div class="card" style="text-align: center;">
        <h1>Your Result</h1>
        <div style="display: flex; justify-content: space-around; margin: 20px 0;">
            <div style="background: #f8f4ff; padding: 20px; border-radius: 10px; flex: 1; margin: 5px;">
                <small>BMI SCORE</small>
                <h2 style="color: #6f42c1; margin: 10px 0;"><%= String.format("%.2f",bmiValueDbl)%></h2>
            </div>
            <div style="background: #f8f4ff; padding: 20px; border-radius: 10px; flex: 1; margin: 5px;">
                <small>CATEGORY</small>
                <h2 style="color: #333; margin: 10px 0;"><%= request.getParameter("category") %></h2>
            </div>
        </div>
        <a href="bmiCalculator.jsp" style="text-decoration:none;"><button class="btn">Calculate Again</button></a>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>