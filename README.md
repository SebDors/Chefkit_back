# ChefKit - Backend

Ce projet constitue le backend de l'application ChefKit. Il s'agit d'une API RESTful développée en Java avec le framework Spring Boot.

## Table des Matières

- [ChefKit - Backend](#chefkit---backend)
  - [Schéma de la base de données](#schéma-de-la-base-de-données)
  - [Démarrage Rapide](#démarrage-rapide)
    - [Prérequis](#prérequis)
    - [Configuration de l&#39;environnement](#configuration-de-lenvironnement)
    - [Lancement de la base de données](#lancement-de-la-base-de-données)
    - [Création et peuplement de la base de données](#création-et-peuplement-de-la-base-de-données)
    - [Lancer l&#39;application](#lancer-lapplication)
  - [Données de Test](#données-de-test)
    - [Aperçu des données](#aperçu-des-données)
    - [Utilisateurs de test](#utilisateurs-de-test)
  - [Documentation de l&#39;API](#documentation-de-lapi)

## Schéma de la base de données

Voici un aperçu du schéma de la base de données utilisée par l'application.

![Schéma de la base de données SVG](chefkit-db.svg)

## Démarrage Rapide

Suivez ces étapes pour configurer et lancer le projet localement.

### Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

- **[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)**
- **[Maven](https://maven.apache.org/download.cgi)**
- **[Docker](https://www.docker.com/products/docker-desktop/)** et **[Docker Compose](https://docs.docker.com/compose/install/)**

### Configuration de l'environnement

Créez un fichier `.env` à la racine du répertoire `back` en vous basant sur le contenu du fichier `docker-compose.yml`. Il devra contenir les variables suivantes :

```dotenv
DATABASE_USER=user
DATABASE_PASSWORD=password
DATABASE_NAME=chefkit
```

### Lancement de la base de données

Utilisez **Docker Compose** pour démarrer le conteneur de la base de données PostgreSQL.

```bash
docker-compose up -d
```

### Initialisation et peuplement de la base de données

Les scripts SQL pour initialiser la base de données (création de la structure et insertion des données de test) se trouvent dans le dossier `initdb`. Grâce à la configuration de `docker-compose.yml`, ces scripts sont **automatiquement exécutés** lors du premier démarrage du conteneur de la base de données via `docker-compose up -d`.

Vous n'avez donc aucune action manuelle à effectuer pour cette étape.

### Lancer l'application

Une fois la base de données prête, vous pouvez lancer l'application **Spring Boot** avec **Maven**.

```bash
./mvnw spring-boot:run
```

L'API sera alors accessible à l'adresse `http://localhost:8080`.

## Données de Test

La base de données est initialisée avec un jeu de données de test pour faciliter l'exploration de l'application.

### Aperçu des données

- **Ingrédients :** Une liste variée d'ingrédients est incluse, couvrant des catégories comme les fruits, les légumes et autres produits de base.
- **Recettes :** Plusieurs recettes sont disponibles, allant de plats simples comme l'Avocado Toast à des plats plus complexes comme les Lasagnes végétariennes. Chaque recette est détaillée avec ses ingrédients, ses instructions, son temps de préparation, etc.
- **Frigos Utilisateurs :** Les frigos de certains utilisateurs sont pré-remplis avec des ingrédients pour permettre de tester la fonctionnalité de suggestion de recettes.

### Utilisateurs de test

Vous pouvez utiliser les comptes suivants pour vous connecter à l'application et tester les différentes fonctionnalités.

| Nom d'utilisateur | Mot de passe | Rôle  | Description                                                          |
| ----------------- | ------------ | ----- | -------------------------------------------------------------------- |
| `seb`             | `password`   | admin | Compte administrateur avec tous les droits.                          |
| `margault`        | `password`   | admin | Compte administrateur avec tous les droits.                          |
| `camille`         | `password`   | admin | Compte administrateur avec tous les droits.                          |
| `test`            | `password`   | user  | Compte utilisateur standard pour tester les fonctionnalités de base. |

## Documentation de l'API

Vous pouvez consulter la documentation de l'API, générée par SpringDoc (OpenAPI), à l'adresse suivante :
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
