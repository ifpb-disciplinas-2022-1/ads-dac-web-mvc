<%-- 
    Document   : listar
    Created on : 25/04/2022, 19:41:21
    Author     : Ricardo Job
--%>
<%@page import="br.edu.ifpb.infra.EditorasEmJDBC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Editoras </title>
</head>
<body>
    <div align="center">
        <form method="POST" action="buscar.jsp">
            <label>Local de Origem: 
                <input type="text" id="localDeOrigem" name="localDeOrigem"/> 
            </label>
            <input type="submit" value="filtrar" />
        </form>
        
        <br/>
        <%
            EditorasEmJDBC editoras = new EditorasEmJDBC();
            Object atributo = request.getAttribute("localDeOrigem");
            
            if(atributo==null)
                request.setAttribute("editoras",editoras.todas());
            else
                request.setAttribute("editoras",editoras.todas());
        %>
        <%@ include file="listar.jsp" %>

    </div>
</body>
</html>