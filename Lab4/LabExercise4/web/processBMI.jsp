<%
    String wStr = request.getParameter("weight");
    String hStr = request.getParameter("height");

    // 2. Initialize variables
    double weight = 0;
    double height = 0;
    double bmi = 0;
    String category = "N/A";

    try {
        if (wStr != null && hStr != null && !wStr.isEmpty() && !hStr.isEmpty()) {

            weight = Double.parseDouble(wStr);
            height = Double.parseDouble(hStr);

            if (height > 0) {

                // BMI formula
                bmi = weight / (height * height);

                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi <= 25.0) {
                    category = "Normal";
                } else {
                    category = "Overweight";
                }
            }
        }
    } catch (NumberFormatException e) {
        category = "Invalid Input";
    }
%>

<jsp:forward page="resultBMI.jsp">
    <jsp:param name="bmiValue" value="<%= bmi %>" />
    <jsp:param name="category" value="<%= category %>" />
</jsp:forward>  