-- =============================================================================
-- SCRIPT DE CRÉATION DE LA BASE DE DONNÉES POUR L'APPLICATION DE RECETTES
-- SGBD: PostgreSQL
--
-- NOTE: Ce script supprime les tables si elles existent déjà avant de les recréer.
-- =============================================================================

-- Il est recommandé de créer la base de données séparément avec la commande :
-- CREATE DATABASE recipe_app;
-- Puis de se connecter à cette base de données pour exécuter le reste du script.

-- =============================================================================
-- SECTION 1: SUPPRESSION DES TABLES EXISTANTES
-- On supprime dans l'ordre inverse de la création pour respecter les contraintes
-- de clés étrangères.
-- =============================================================================

DROP TABLE IF EXISTS frigo_utilisateur;

DROP TABLE IF EXISTS recette_ingredients;

DROP TABLE IF EXISTS utilisateurs;

DROP TABLE IF EXISTS recettes;

DROP TABLE IF EXISTS ingredients;

-- =============================================================================
-- SECTION 2: CRÉATION DES TABLES
-- =============================================================================

-- =============================================================================
-- TABLE: utilisateurs
-- Description: Stocke les informations des utilisateurs de l'application.
-- =============================================================================
CREATE TABLE utilisateurs (
    id_utilisateur SERIAL PRIMARY KEY,
    nom_utilisateur VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    date_creation TIMESTAMP WITH TIME ZONE DEFAULT NOW()
);

COMMENT ON TABLE utilisateurs IS 'Contient les informations des comptes utilisateurs.';

-- =============================================================================
-- TABLE: ingredients
-- Description: Catalogue de tous les ingrédients disponibles dans l'application.
-- =============================================================================
CREATE TABLE ingredients (
    id_ingredient SERIAL PRIMARY KEY,
    nom_ingredient VARCHAR(100) UNIQUE NOT NULL,
    path_image VARCHAR(255)
);

COMMENT ON TABLE ingredients IS 'Liste de tous les ingrédients possibles pouvant être utilisés dans les recettes.';

-- =============================================================================
-- TABLE: recettes
-- Description: Contient toutes les recettes pré-enregistrées.
-- =============================================================================
CREATE TABLE recettes (
    id_recette SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    description TEXT,
    instructions TEXT NOT NULL,
    temps_preparation_minutes INT CHECK (
        temps_preparation_minutes >= 0
    ),
    temps_cuisson_minutes INT CHECK (temps_cuisson_minutes >= 0),
    nombre_personnes INT CHECK (nombre_personnes > 0),
    path_image VARCHAR(255)
);

COMMENT ON TABLE recettes IS 'Contient les détails de chaque recette disponible dans l''application.';

-- =============================================================================
-- TABLE: recette_ingredients
-- Description: Table de liaison qui associe les recettes à leurs ingrédients
--              et spécifie la quantité nécessaire.
-- =============================================================================
CREATE TABLE recette_ingredients (
    id_recette INT NOT NULL,
    id_ingredient INT NOT NULL,
    quantite VARCHAR(50), -- ex: "200", "1.5", "une pincée"
    unite VARCHAR(50),    -- ex: "g", "L", "cuillère à soupe", "unité"

-- Clé primaire composite pour qu'un ingrédient n'apparaisse qu'une fois par recette.
PRIMARY KEY (id_recette, id_ingredient),

-- Clés étrangères


CONSTRAINT fk_recette
        FOREIGN KEY (id_recette)
        REFERENCES recettes(id_recette)
        ON DELETE CASCADE, -- Si une recette est supprimée, ses associations d'ingrédients le sont aussi.

    CONSTRAINT fk_ingredient
        FOREIGN KEY (id_ingredient)
        REFERENCES ingredients(id_ingredient)
        ON DELETE CASCADE -- Si un ingrédient est supprimé, il est retiré de toutes les recettes.
);

COMMENT ON TABLE recette_ingredients IS 'Fait le lien entre les recettes et les ingrédients nécessaires, avec la quantité.';

COMMENT ON COLUMN recette_ingredients.quantite IS 'La quantité de l''ingrédient requise.';

COMMENT ON COLUMN recette_ingredients.unite IS 'L''unité de mesure pour la quantité (g, ml, unité, etc.).';

-- =============================================================================
-- TABLE: frigo_utilisateur
-- Description: Table de liaison pour stocker les ingrédients qu'un utilisateur possède.
-- =============================================================================
CREATE TABLE frigo_utilisateur (
    id_utilisateur INT NOT NULL,
    id_ingredient INT NOT NULL,

-- Clé primaire composite
PRIMARY KEY (id_utilisateur, id_ingredient),

-- Clés étrangères


CONSTRAINT fk_utilisateur
        FOREIGN KEY (id_utilisateur)
        REFERENCES utilisateurs(id_utilisateur)
        ON DELETE CASCADE,

    CONSTRAINT fk_ingredient
        FOREIGN KEY (id_ingredient)
        REFERENCES ingredients(id_ingredient)
        ON DELETE CASCADE
);

COMMENT ON TABLE frigo_utilisateur IS 'Représente les ingrédients présents dans le frigo de chaque utilisateur.';