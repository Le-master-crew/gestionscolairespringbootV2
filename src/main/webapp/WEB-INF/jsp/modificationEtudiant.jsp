<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<title>Modification de l'étudiant</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="accueil.jsp">Gestion Etudiants</a>
	  	<div class="collapse navbar-collapse" id="navbarNavDropdown">
    		<ul class="navbar-nav">
    			<li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Menu étudiant
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			          <a class="dropdown-item" href="listeEtudiants">Lister étudiants</a>
			          <a class="dropdown-item" href="getFormLireEtudiant">Info étudiant</a>
			          <a class="dropdown-item" href="getFormSupprimerEtudiant">Supprimer un étudiant</a>
			          <a class="dropdown-item" href="getFormModifierEtudiant">Modifier un étudiant</a>
			          <a class="dropdown-item" href="getFormAjoutEtudiant">Ajouter un étudiant</a>
			          <a class="dropdown-item" href="getFormAjoutEtudiantCours">Rajouter un étudiant à un cours</a>
			        </div>
			    </li>
				<li class="nav-item active" style="padding-right: 10px">
		       		<a class="nav-link" href="/getFormLogin">Déconnexion <span class="sr-only">(current)</span></a>
		   		</li>
    		</ul>
  		</div>
	</nav>
	<div class="jumbotron">
	  <h1>Modification étudiant</h1>
	</div>
	<div class="container">					
		<div class="card card-container">
			<p id="profile-name" class="profile-name-card">Formulaire de modification d'un étudiant</p>
			<c items="${etudiant}" var="etudiant">
				<form class="form-signin" action="udpateEtudiant" method="post">
					<input name="idEtudiant" type="number" id="inputEmail" class="form-control" placeholder="Nom" value="${etudiant.id}" autofocus readonly>
					<input name="nom" type="text" id="inputEmail" class="form-control" placeholder="Nom" value="${etudiant.nom}" autofocus>
	                <input name="prenom" type="text" id="inputEmail" class="form-control" placeholder="Prenom" value="${etudiant.prenom}" required autofocus>
	                <input name="mail" type="text" id="inputEmail" class="form-control" placeholder="Mail" value="${etudiant.mail}" required autofocus>
	                <input name="adresse" type="text" id="inputEmail" class="form-control" placeholder="Adresse" value="${etudiant.adresse}" required autofocus>
	                <input name="telephone" type="number" id="inputEmail" class="form-control" placeholder="Téléphone" value="${etudiant.telephone}" required autofocus>
	                <input name="dateNaissance" type="text" id="inputEmail" class="form-control" placeholder="Date de Naissance" value="${etudiant.dateNaissance}" required autofocus>
               		
               		<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Modifier</button>        		                		                		
                </form>  
			</c>
		</div>  		
	</div>
	<div class="container">		
		
	</div>
</body>
</html>