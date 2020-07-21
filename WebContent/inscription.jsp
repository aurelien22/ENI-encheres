<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>S'inscrire à ENI-enchères</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container">
  		<div class="col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6">
    <div class="header">

      <div class="header__text-group text-center">
        <h1 class="header__heading">Inscription</h1>
      </div> <!-- close .text-group -->
    </div> <!-- close .header -->
    
    <hr />
    
    <div class="form-register">
      <form name="register" method="post" action="<%=request.getContextPath()%>/utilisateurs">
        <div class="row">
          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_first_name">Prenom</label>
              <input autofocus="autofocus" class="form-control" required="required" type="text" name="prenom" id="user_first_name">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->

          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_last_name">Nom</label>
              <input class="form-control" type="text" name="nom" id="user_last_name">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->
        </div> <!-- close .row -->

        <div class="form-group">
          <label for="user_email">
            Adresse email
          </label>
          <input class="form-control" type="email" value="" name="email" id="user_email" data-cip-id="cIPJQ342845639">

        </div> <!-- close .form-group -->

        <div class="form-group">
          <label for="user_username">
            Pseudo
          </label>
          <input class="form-control" required="required" type="text" name="pseudo" id="user_username" data-cip-id="user_username" autocomplete="off">
        </div> <!-- close .form-group -->

        <div class="form-group">
          <label for="user_password">
            Mot de passe <span class="text-secondary">(6 characteres minimum)</span>
          </label>
          <input autocomplete="off" class="form-control" required="required" type="password" name="motdepasse" id="user_password" data-cip-id="cIPJQ342845640">

        </div> <!-- close .form-group -->
		
		<div class="form-group">
          <label for="user_username">
            Adresse
          </label>
          <input class="form-control" required="required" type="text" name="rue" id="user_username" data-cip-id="user_username" autocomplete="off">
        </div> <!-- close .form-group -->
		
		<div class="row">
          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_first_name">Code postal</label>
              <input autofocus="autofocus" class="form-control" required="required" type="text" name="codepostal" id="user_first_name">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->

          <div class="col-xs-6">
            <div class="form-group">
              <label for="user_last_name">Ville</label>
              <input class="form-control" type="text" name="ville" id="user_last_name">
            </div> <!-- close .form-group -->
          </div> <!-- close .col -->
        </div> <!-- close .row -->
		
		<div class="form-group">
          <label for="user_username">
            Numero de telephone
          </label>
          <input class="form-control" required="required" type="text" name="telephone" id="user_username" data-cip-id="user_username" autocomplete="off">
        </div> <!-- close .form-group -->

        <div class="form-group">
          <input type="submit" value="S'inscrire" class="btn btn-success login-btn">
          <a href="<%=request.getContextPath()%>"><input type="button" value="Annuler" class="btn btn-success login-btn"></a>
        </div> <!-- close .form-group -->

        <div class="form-group text-center">
          <p class="text-secondary zeta">
            En vous inscrivant, vous acceptez les <a href="/terms">les regles d'usage de l'application</a>.
          </p>
        </div>
      </form>
    </div> <!-- close .form -->

    <div class="sheet sheet--padding-small text-center">
      <p class="epsilon">Deja inscrit ? <a href="<%=request.getContextPath()%>/connexion.jsp">Se connecter</a></p>
    </div>

  </div>
</div>
</body>
</html>
