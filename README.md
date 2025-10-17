# ChefKit - Backend

Ce projet constitue le backend de l'application ChefKit. Il s'agit d'une API RESTful développée en Java avec le framework Spring Boot.

## Schéma de la base de données

Voici un aperçu du schéma de la base de données utilisée par l'application.

![Schéma de la base de données SVG](chefkit-db.svg)

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/products/docker-desktop/) et [Docker Compose](https://docs.docker.com/compose/install/)

## Démarrage

Suivez ces étapes pour configurer et lancer le projet localement.

### 1. Configuration de l'environnement

Créez un fichier `.env` à la racine du répertoire `back` en vous basant sur le contenu du fichier `docker-compose.yml`. Il devra contenir les variables suivantes :

```
DATABASE_USER=user
DATABASE_PASSWORD=password
DATABASE_NAME=chefkit
```

### 2. Lancement de la base de données

Utilisez Docker Compose pour démarrer le conteneur de la base de données PostgreSQL.

```bash
docker-compose up -d
```

### 3. Création et peuplement de la base de données

Les scripts SQL pour initialiser la base de données se trouvent dans le dossier `initdb`.

1.  **Créez la structure de la base de données :**
    Exécutez le script `createDatabase.sql` pour créer les tables et les relations nécessaires. Vous pouvez utiliser un client SQL comme `psql` ou DBeaver.

2.  **Insérez les données initiales :**
    Exécutez le script `importData.sql` pour peupler la base de données avec des données de test.

### 4. Lancer l'application

Une fois la base de données prête, vous pouvez lancer l'application Spring Boot avec Maven.

```bash
./mvnw spring-boot:run
```

L'API sera alors accessible à l'adresse `http://localhost:8080`.

## Documentation de l'API

Vous pouvez consulter la documentation de l'API, générée par SpringDoc (OpenAPI), à l'adresse suivante :
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
