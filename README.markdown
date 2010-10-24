Agenda
======

__Agenda__ est une application qui servira de base pour illustrer certains exemples vus en classe p.e.:

- Architecture en niveaux
- MVC2
- _Repository_, _Factory_, _Façade métier_, _Coordonateur_, etc.

Compilation et dépendances
--------------------------

Pour compiler et installer __Agenda__, le logiciel [Maven](http://maven.apache.org/download.html "Maven") est nécessaire.

Si vous avez le logiciel _git_, vous pouvez cloner le projet comme ceci:

    prompt> git clone http://github.com/fxg42/mgl7361.git mgl7361

Sinon, [téléchargez](http://github.com/fxg42/mgl7361/zipball/master "zipball") le code source en format zip et désarchivez-le dans le répertoire "mgl7361".

La compilation et l'exécution du projet se font ainsi:

    prompt> cd mgl7361/agenda
    prompt> mvn clean install
    prompt> cd web
    prompt> mvn tomcat:run-war -Dtomcat.maven.path=/agenda

Vous pourrez alors accéder à l'application depuis votre fureteur à l'adresse [http://localhost:8080/agenda/evenements/list.html](http://localhost:8080/agenda/evenements/list.html).

Description _(très)_ sommaire
-----------------------------

- Le module _api_ contient la façade métier ainsi que la seule classe du modèle.
- Le module _core_ contient l'implémentation de la couche métier.
- Le module _persistence_ contient les classes qui sont responsables de l'accès à la base de données ainsi que la sérialisation/désérialisation des objets.
- Le module _web_ contient les contrôleurs et les gabarits des pages web.
- Le module _services_ contient certaines classes utilitaires.
