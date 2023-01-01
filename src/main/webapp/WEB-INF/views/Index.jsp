<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MIR
  Date: 10-Nov-22
  Time: 2:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Income tax calculator</title>
</head>
<body>
<h1>Income Tax Calculator Bangladesh</h1>
<form:form action="ivalue" modelAttribute="imodel">


<%--        <label for="Gender">Gender:</label>--%>
<%--        <form:input path="Gender" id="ender"/>--%>
<%--        <form:errors path="Gender"/>--%>

<%--        <br><br>--%>

<%--        <input type="submit">--%>


<table>
    <tr>
        <td>Area</td>
        <td>Amount</td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><input type="text" name="gender" value=""></td>
    </tr>
    <tr>
        <td>Basic Salary</td>
        <td><input type="text" name="b_sal" value=""></td>
    </tr>
    <tr>
        <td>House Rent</td>
        <td><input type="text" name="h_rent" value=""></td>
    </tr>
    <tr>
        <td>Medical Allowance</td>
        <td><input type="text" name="m_allowance" value=""></td>
    </tr>
    <tr>
        <td>Conveyance</td>
        <td><input type="text" name="conveyance" value=""></td>
    </tr>
    <tr>
        <td>Festival Bonus</td>
        <td><input type="text" name="f_bonus" value=""></td>
    </tr>
    <tr>
        <td>Others</td>
        <td><input type="text" name="others" value=""></td>
    </tr>
    <tr>
        <td></td>
        <td><input name="submit" type="submit"></td>
    </tr>

</table>
</form:form>
</body>
</html>
