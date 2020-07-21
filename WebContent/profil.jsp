<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	Pseudo : <c:out value="${utilisateur.pseudo }" /> </br>
	Nom : <c:out value="${utilisateur.nom }" /> </br>
	Prenom : <c:out value="${utilisateur.prenom }" /> </br>
	Email : <c:out value="${utilisateur.email }" /> </br>
	Telephone : <c:out value="${utilisateur.telephone }" /> </br>
	Rue : <c:out value="${utilisateur.rue }" /> </br>
	Code postal : <c:out value="${utilisateur.codePostal }" /> </br>
	Ville : <c:out value="${utilisateur.ville }" />
	
</body>
</html>