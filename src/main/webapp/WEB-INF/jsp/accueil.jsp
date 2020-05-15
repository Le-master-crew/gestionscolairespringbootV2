<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="eu.ensup.gestionscolairespringboot.domaine.Etudiant"%>

<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="css/style.css">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<title>Profil</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
 		<a class="navbar-brand" href="accueil.jsp">Gestion Etudiants</a>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active" style="padding-right: 10px">
					<a class="nav-link" href="/getFormLogin">Déconnexion <span class="sr-only">(current)</span></a>
				</li>
			</ul>
		</div>
	</nav>

<div class="container">
	<div class="row" style="margin-top: -50px;margin-bottom: -70px;">
		<div class="card" style="width: 220px;">
		  <img src="./images/accueil/people.jpg" class="card-img-top" alt="Liste étudiants">
		  <div class="card-body">
		    <h5 class="card-title" style="text-align: center">Lister les étudiants</h5>
    		<a href="listeEtudiants" class="stretched-link"></a>
		  </div>
		</div>
		<div class="card" style="width: 220px;">
		  <img src="./images/accueil/book.jpg" class="card-img-top" alt="Information étudiant">
		  <div class="card-body">
		    <h5 class="card-title" style="text-align: center">Information étudiant</h5>
    		<a href="getFormLireEtudiant" class="stretched-link"></a>
		  </div>
		</div>
		<div class="card" style="width: 220px;">
		  <img src="./images/accueil/children.jpg" class="card-img-top" alt="Supprimer étudiant">
		  <div class="card-body">
		    <h5 class="card-title" style="text-align: center">Supprimer étudiant</h5>
    		<a href="getFormSupprimerEtudiant" class="stretched-link"></a>
		  </div>
		</div>
	</div>
	<div class="row" style="margin-top: -50px;margin-bottom: -70px;">
		<div class="card" style="width: 220px;">
		  <img src="./images/accueil/geometry.jpg" class="card-img-top" alt="Modifié étudiant">
		  <div class="card-body">
		    <h5 class="card-title" style="text-align: center">Modifier étudiant</h5>
    		<a href="getFormModifierEtudiant" class="stretched-link"></a>
		  </div>
		</div>
		<div class="card" style="width: 220px;">
		  <img src="./images/accueil/laptop.jpg" class="card-img-top" alt="Ajout étudiant">
		  <div class="card-body">
		    <h5 class="card-title" style="text-align: center">Ajouter un étudiant</h5>
    		<a href="getFormAjoutEtudiant" class="stretched-link"></a>
		  </div>
		</div>
		<div class="card" style="width: 220px;">
		  <img src="./images/accueil/laptop2.jpg" class="card-img-top" alt="Ajout étudiant cours">
		  <div class="card-body">
		    <h5 class="card-title" style="text-align: center">Ajouter un étudiant à un cours</h5>
    		<a href="getFormAjoutEtudiantCours" class="stretched-link"></a>
		  </div>
		</div>
	</div>
</div>
</body>
</html>