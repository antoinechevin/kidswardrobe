# Spécification UI/UX : Gap Analysis Textile Enfant

**Version :** 1.1  
**Statut :** Validé  
**Auteur :** Sally (UX Expert)  
**Projet :** Inventaire Textile & Gap Analysis

## 1. Vision et Principes de Conception
L'objectif est de réduire la charge mentale des parents en transformant un inventaire passif en un outil d'aide à la décision ("Qu'est-ce qu'il me manque ?").

* **Priorité au "Gap" :** Le tableau de bord affiche d'abord ce qui manque par rapport aux quotas définis.
* **Batch Input (Saisie à la chaîne) :** Interface optimisée pour la réception de lots massifs (ex: arrivage Vinted), minimisant les actions répétitives.
* **Zéro Clavier :** Utilisation de sélecteurs visuels larges ("Pills") pour une utilisation rapide à une main.
* **Filtrage par Saison :** La saison choisie en début de flux filtre dynamiquement les types de vêtements proposés.

## 2. Architecture de l'Information (IA)
L'application est une PWA (Progressive Web App) structurée autour d'une barre de navigation inférieure (Tab Bar).

* **Dashboard** : Vue prioritaire des manquants par enfant, filtrée par saison (Hiver/Été).
* **Inventaire** : Vue exhaustive du stock possédé, permettant de consulter ou supprimer des articles.
* **Ajouter (+)** : Modale de saisie rapide persistante (Mode Batch).
* **Configuration** : Gestion des quotas par type et création/activation des "Packs Thématiques" (ex: Pack Ski).
* **Profil** : Gestion des profils enfants et mise à jour rapide de la taille actuelle de l'enfant.

## 3. Flux de Saisie "Batch Mode" (Prioritaire)
Ce flux est conçu pour saisir un lot complet d'articles de la même saison/taille sans quitter la modale :

1. **Initialisation :** - Sélection de l'Enfant.
   - Sélection de la Saison (❄️ Froid / ☀️ Chaud).
   - Sélection de la Taille (pré-remplie sur la taille actuelle de l'enfant).
2. **Boucle de saisie itérative :**
   - L'écran affiche les **Types** d'articles (ex: Pull, Body ML) filtrés par la saison choisie.
   - L'utilisateur clique sur le **Type**.
   - L'utilisateur ajuste la **Quantité** (ex: 3) via des boutons `[ + ]`.
   - Clic sur **"Ajouter et Continuer"**.
3. **Persistance :** - Un message de confirmation apparaît ("✅ 3 Pulls ajoutés").
   - La modale reste ouverte.
   - L'enfant, la saison et la taille restent sélectionnés. Seul le type est réinitialisé.
4. **Terminer :** Clic sur "Terminer" pour fermer la modale et voir le Dashboard mis à jour.

## 4. Wireframes Textuels

### A. Gap Dashboard (Accueil)
```text
+----------------------------------------------------+
|  [Menu]        Léo - 24 mois          [Modifier]   |
+----------------------------------------------------+
|  SAISON : [ ❄️ FROID ]  [ ☀️ CHAUD ]               |
+----------------------------------------------------+
|  URGENCE QUOTIDIEN (Manques)                       |
|  +----------------------------------------------+  |
|  | [👕] Body Manches Longues                    |  |
|  |      Objectif : 10 | Stock : 5               |  |
|  |      [ Badge Rouge : MANQUE 5 ]              |  |
|  +----------------------------------------------+  |
|                                                    |
|  PACKS : "Vacances Neige" (Actif)                  |
|  +----------------------------------------------+  |
|  | [⛄] Combinaison Pilote                        |  |
|  |      Progression : [====......] 1/3 OK       |  |
|  +----------------------------------------------+  |
+----------------------------------------------------+
| [■ Dash]  [□ Stock]   [(+)]    [□ Packs]  [□ Profil]|
+----------------------------------------------------+
```

### B. Quick Add Modal (Mode Batch)
```text
+----------------------------------------------------+
|                  SAISIE DU LOT                     |
|  Léo  |  ❄️ FROID  |  Taille : 24M                 |
+----------------------------------------------------+
|  TYPE D'ARTICLE (Filtré Froid) :                   |
|  [👕 Col Roulé]  [🧥 Manteau]  [🌙 Pyj. Velours]   |
|                                                    |
|  QUANTITÉ :      [ - ]      [  1  ]      [ + ]     | 
+----------------------------------------------------+
|          [ + AJOUTER ET CONTINUER ]                |
|           [ Terminer la saisie ]                   |
+----------------------------------------------------+
```

## 5. Guide de Style et Accessibilité
* Couleurs : État Critique : Rouge (#EF4444)
* État Quota Atteint : Vert (#10B981)
* Action principale : Bleu Indigo (#4F46E5)
* Composants : Cartes à bords arrondis (12px), boutons de sélection de type "Pills" (hauteur min 44px pour le pouce).
* Accessibilité : Taille de police 16px minimum pour les données chiffrées. Support du contraste élevé pour les badges.