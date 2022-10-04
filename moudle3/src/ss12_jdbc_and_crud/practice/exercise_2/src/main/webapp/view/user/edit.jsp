<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${user.name}' />"
                    />
                    <p style="text-align: left;color: red">
                        <c:if test="${messageNameError!=null}">
                            ${messageNameError}
                        </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${user.email}' />"
                    />
                    <p style="text-align: left;color: red">
                        <c:if test="${messageEmailError!=null}">
                            ${messageEmailError}
                        </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${user.country}' />"
                    />
                    <p style="text-align: left;color: red">
                        <c:if test="${messageCountryError!=null}">
                            ${messageCountryError}
                        </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<p style="text-align: center">
    <span style="color:blue">
        <c:if test="${messageSuccess!=null}">
            ${messageSuccess}
        </c:if>
    </span>
</p>
</body>
</html>