<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page enchère</title>
</head>
<body>

	<h1>Détail vente</h1>
	
	${article.nomArticle } <br>
	
	Description : ${article.description } <br>
	
	Catégorie : ${article.categorie.libelle } <br>
	
	Meilleur offre : <br>
	
	Mise à prix : ${article.miseAPrix } <br>
	
	Fin de l'enchère : ${article.dateFinEncheres } <br>
	
	Retrait : ${article.utilisateur.rue } ${article.utilisateur.codePostal } ${article.utilisateur.ville } <br>
	
	Vendeur : ${article.utilisateur.pseudo } <br>

	Ma proposition : 
			
			
	<form action="<%=request.getContextPath()%>/encheres" method="post">
	
		<input id="noArticle" name="noArticle" type="hidden" value="${article.noArticle }">
	
		<input class="form-control" required="required" type="number" name="proposition" id="proposition" autocomplete="off" step="10" value="${article.miseAPrix + 10 }" min="${article.miseAPrix + 10 }" max = "1000"/>
		
		<button type="submit">Enchérir</button>
		
	</form>
	
	<p style="color: green;"> ${message } </p>


</body>
</html>