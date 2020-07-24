<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<h1>Liste des encheres</h1>

	<c:choose>
		<c:when test="${!empty sessionScope.sessionUtilisateur}">
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/gestionArticles">Encheres</a></li>
					<li><a href="<%=request.getContextPath()%>/creationVente.jsp">Vendre un article</a></li>
					<li><a href="<%=request.getContextPath()%>/utilisateurs?action=afficher&noUtilisateur=${sessionScope.sessionUtilisateur.noUtilisateur}">Mon profil</a></li>
					<li><a href="<%=request.getContextPath()%>/deconnexion">Deconnexion</a></li>
				</ul>
			</nav>
		</c:when>
		<c:when test="${empty sessionScope.sessionUtilisateur}">
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>/inscription.jsp">S'inscrire</a></li>
					<li><a href="<%=request.getContextPath()%>/connexion.jsp">Se connecter</a></li>
				</ul>
			</nav>
		</c:when>
	</c:choose>
	
	<h3>Filtres</h3>
	
	<form>
		<input type="text" />
		<label>Catégorie</label>
		<select name="categorie" id="categorie-select" size="1">
			<option value="1">Maison
			<option value="2">Informatique
		</select>
		<input type="submit" value="Rechercher" class="btn btn-primary">
	</form>
	
	<c:forEach var="article" items="${listeArticles}">
	
		<div class="article">
			<h2>${article.nomArticle}</h2>
			Prix : ${article.miseAPrix} points
			</br>
			Fin de l'enchère : ${article.dateFinEncheres }
			</br>
			Vendeur : <a href="<%=request.getContextPath()%>/utilisateurs?action=afficher&noUtilisateur=${article.utilisateur.noUtilisateur }">${article.utilisateur.pseudo }</a>		
		</div>
	
	</c:forEach>

</body>
</html>