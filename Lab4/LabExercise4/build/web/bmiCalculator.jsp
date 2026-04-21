<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>BMI Calculator</title></head>
<body>
    <jsp:include page="header.jsp" />

    <div class="card">
        <h1>BMI Calculator</h1>
        <form action="processBMI.jsp" method="POST">
            <p>Weight (kg):<br>
            <input type="number" name="weight" step="0.01" style="width:100%; padding:10px; margin-top:5px;" required></p>
            
            <p>Height (m):<br>
            <input type="number" name="height" step="0.01" style="width:100%; padding:10px; margin-top:5px;" required></p>
            
            <input type="submit" class="btn" value="Calculate BMI">
        </form>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>