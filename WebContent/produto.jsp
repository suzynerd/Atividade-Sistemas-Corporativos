<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add Produto</title>
</head>
<body>
    <form method="POST" action='ProdutoController' name="frmAddProduto">
        Produto ID : <input type="text" readonly="readonly" name="produtoid"
            value="<c:out value="${produto.produtoid}" />" /> <br /> 
        Produto Nome : <input
            type="text" name="produtonome"
            value="<c:out value="${user.produtonome}" />" /> <br /> 
        Descrição : <input
            type="text" name="descricao"
            value="<c:out value="${user.descricao}" />" /> <br /> 
    </form>
</body>
</html>