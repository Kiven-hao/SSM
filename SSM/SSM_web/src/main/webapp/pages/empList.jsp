<%--
  Created by IntelliJ IDEA.
  User: Kiven
  Date: 2018/10/28
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Emp遍历</title>
</head>
<body>
  <table border="1" align="">
      <tr>
          <td>员工编号</td>
          <td>员工姓名</td>
          <td>入职日期</td>
          <td>员工薪资</td>
      </tr>
      <c:forEach items="${empList}" var="emp">
          <tr>
          <td>${emp.empNo}</td>
          <td>${emp.ename}</td>
          <td>${emp.hireDate}</td>
          <td>${emp.sal}</td>
          </tr>
      </c:forEach>
  </table>
</body>
</html>