# gestionscolairespringboot

L'application a été développée avec Spring Boot. Celle-ci permet de gérer les étudiants d'une école.
Plusieurs fonctionnalités sont disponibles :
- connexion à la plateforme
- lister les étudiants
- lister les cours
- ajouter un étudiant
- supprimer un étudiant
- modifier un étudiant
- lire les informations d'un étudiant
- associer un étudiant à un cours

Prérequis :
- Installation du serveur de base de données sur la machine (XAMPP ou WAMPP)
- Créer la base de données "gestionscolaire".


Lancement de l'application :
- Télécharger le projet
- A partir de la racine du projet executer la commande : mvn spring-boot:run
- A partir d'un navigateur, accéder à : http://localhost:8080/ . Voici l'écran de connexion où vous pouvez vous connecter avec le compte admin

  - identifiant : root
  - mot de passe : root

Swagger :
Lorsque l'application est lancée aller sur : http://localhost:8080/swagger-ui.html#/
