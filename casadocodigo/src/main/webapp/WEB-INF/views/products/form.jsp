<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Livros</title>
</head>
<body>
	
	<form:form action="${spring:mvcUrl('PC#save').build()}" enctype="multipart/form-data" method="post" commandName="product">
	<div>
	<label for="title">Título</label>
	<form:input path="title" id="title" />
	<form:errors path="title" />
	</div>
	
	<div>
	<label for="description">Descrição</label>
	<form:textarea path="description" rows="10" cols="20" id="description" />
	<form:errors path="description" />
	</div>
	
	
	<div>
	<label for="numberOfPages">Número de Páginas</label>
	<form:input path="numberOfPages" id="numberOfPages" />
	<form:errors path="numberOfPages" />
	</div>
	
	<div>
	<label for="releaseDate">Data de lancamento</label>
	<form:input path="releaseDate" type="date" id="releaseDate" />
	<form:errors path="releaseDate" />
	</div>
	
	<div>
	<label for="summary">Sumario do Livro</label>
	<input type="file" name="summary" id="summary" />
	<form:errors path="summaryPath" />
	</div>
	
	
	<div> 
		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="price_${bookType}">${bookType}</label>
				<input type="text" name="prices[${status.index}].value" id="price_${bookType}"/>
				<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
			</div>
		</c:forEach>
	</div>
	<div>
	<input type="submit" value="Enviar" />
	</div>
	</form:form>
</body>
</html>