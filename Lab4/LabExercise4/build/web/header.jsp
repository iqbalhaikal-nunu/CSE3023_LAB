<style>
    body {
        font-family: 'Segoe UI', Arial, sans-serif;
        background-color: #f0f2f5;
        margin: 0;
        padding: 20px;
        color: #333;
    }
    header {
        background: linear-gradient(135deg, #6f42c1, #4e227e);
        color: white;
        padding: 25px;
        border-radius: 12px;
        text-align: center;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        margin-bottom: 25px;
    }
    nav a {
        color: #e0d0ff;
        text-decoration: none;
        margin: 0 15px;
        font-weight: bold;
    }
    nav a:hover {
        color: white;
        text-decoration: underline;
    }
    .card {
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.05);
        max-width: 600px;
        margin: auto;
    }
    h1 { color: #4e227e; border-left: 5px solid #6f42c1; padding-left: 15px; }
    .btn {
        background-color: #6f42c1;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }
    .btn:hover { background-color: #5a32a3; }
</style>

<header>
    <h2>Health Management System</h2>
    <nav>
        <a href="bmiCalculator.jsp">BMI Calculator</a>
        <a href="healthInfo.jsp">Health Info</a>
    </nav>
</header>