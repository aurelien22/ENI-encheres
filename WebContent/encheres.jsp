<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<h1>Liste des encheres</h1>
	
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
	
	<div class="article">
		<h2>PC Gamer pour travailler</h2>
		Prix : 210 points
		</br>
		Fin de l'enchère : 10/08/2020
		</br>
		Vendeur : <a>jennifer22</a>		
	</div>

	<div class="article">
		<h2>Rocket stove pour riz et pates</h2>
		Prix : 195 points
		</br>
		Fin de l'enchère : 09/08/2020
		</br>
		Vendeur : <a>aurelien22</a>		
	</div>

</body>
</html>