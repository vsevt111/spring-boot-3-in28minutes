<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Your Name: ${name}</h1>
		<div>
			<a href="list-todos">Manage</a> your todo list
		</div>
	</div>
<%@include file="common/footer.jspf"%>