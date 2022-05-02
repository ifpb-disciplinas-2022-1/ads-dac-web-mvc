<%-- 
    Document   : listar
    Created on : 25/04/2022, 19:41:21
    Author     : Ricardo Job
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Livros </title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Listagem de Livros</h2></caption>
            <tr>
                <th>##</th>
                <th>Título</th>
            </tr>
            <c:forEach var="livro" items="#{requestScope.livros}">
                <tr>
                    <td><c:out value="${livro.id}" /></td>
                    <td><c:out value="${livro.titulo}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>