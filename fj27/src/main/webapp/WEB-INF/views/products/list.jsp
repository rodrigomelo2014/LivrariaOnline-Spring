<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib tagdir="/WEB-INF/tags" prefix="cdc" %>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<cdc:page title="Listagem de Produtos">
<spring:message code="users.welcome" arguments="${user.name}"/>
<c:url value="/products/form" var="formLink" />
<a href="${formLink}">Cadastrar novo produto</a>
	<h1>${sucesso}</h1>
	<table>
		<tr>
			<th>Titulos</th>
			<th>Valores</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.title}</td>
				<td>
					<c:forEach items="${product.prices}" var="price">
						[${price.value} - ${price.bookType}]
				</c:forEach>
				</td>
				<td>
					<c:url value="/products/${product.id}" var="linkDetalhar" />
					<a href="${linkDetalhar}">Detalhar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</cdc:page>
