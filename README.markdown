Agenda
======

__Agenda__ est une application qui servira de base pour illustrer certains exemples vus en classe p.e.:

- Architecture en niveaux
- MVC2
- _Repository_, _Factory_
- etc...

Compilation et dépendances
--------------------------

Pour compiler et installer __Agenda__, certains logiciels sont nécessaires:

- Maven
- Tomcat (ou un autre conteneur de servlet Java)
- PostgreSQL (ou une autre base de données relationnelle)

Le script de création de table et la configuration de la DataSource se trouvent dans le répertoire suivant:

    agenda/web/src/main/webapp/META-INF/create-schema.sql
    agenda/web/src/main/webapp/META-INF/context.xml

Il est probable que vous deviez modifier ces deux fichiers avec les paramètres de votre propre base de données.

Le téléchargement, la compilation et l'installation du projet se fait ainsi:

    prompt> git clone http://github.com/fxg42/mgl7361.git mgl7361
    prompt> cd mgl7361/agenda
    
    [ modifications manuelles aux fichiers create-schema.sql et context.xml ]
    
    prompt> mvn clean package
    prompt> cp web/target/agenda.war $TOMCAT_HOME/webapps/

