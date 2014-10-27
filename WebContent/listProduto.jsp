<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Produtos</title>
</head>
<body>
		 <table border=1>
        <thead>
            <tr>
                <th>Produto Id</th>
                <th>Produto Nome</th>
                <th>Descricao</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><c:out value="${produto.produtoid}" /></td>
                    <td><c:out value="${produto.produtonome}" /></td>
                    <td><c:out value="${produto.descricao}" /></td>
                    <td><a href="ProdutoController?action=edit&produtoid=<c:out value="${produto.produtoid}"/>">Update</a></td>
                    <td><a href="ProdutoController?action=delete&produtoid=<c:out value="${produto.produtoid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ProdutoController?action=insert">Add Produto</a></p>
</body>
</html>