<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The 'isErrorPage' attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The **errorPage** attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit that Burgerrrr!!!</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<h1>Edit Burger</h1>
		
		<div class="adding-section">
			<form:form class="form" action="" method="put" modelAttribute="burger">
				<input type="hidden" name="_method" value="put">
				<div class="burger-name">
					<div class="frontSection">
						<form:label path="burgerName">Burger Name</form:label>
						<form:errors path="burgerName" class="text-danger"></form:errors>
					</div>
					<form:input path="burgerName"></form:input>
				</div>
				<div class="restaurant-name">
					<div class="frontSection">
						<form:label path="restaurantName">Restaurant Name</form:label>
						<form:errors path="restaurantName" class="text-danger"></form:errors>
					</div>
					<form:input path="restaurantName"></form:input>
				</div>
				<div class="input-rating">
					<div class="frontSection">
						<form:label path="rating">Rating</form:label>
						<form:errors path="rating" class="text-danger"></form:errors>
					</div>
					<form:input type="number" path="rating"></form:input>
				</div>
				<div class="input-notes">
					<div class="frontSection">
						<form:label path="notes">Notes</form:label>
						<form:errors path="notes" class="text-danger"></form:errors>
					</div>
					<form:input type="textarea" path="notes" rows="5" cols="50"></form:input>
				</div>
				<input class="submit" type="submit" value="Submit"/>
			</form:form>
		</div>
		
	</div>
</body>
</html>