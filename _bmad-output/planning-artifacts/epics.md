# Backlog des Epics & Stories

Ce document est la source de vérité pour le développement, dérivé du [PRD](../analysis/product-requirements.md).

## Epic 3 : Quotas et Packs (Requirements Management)
**Objectif** : Permettre aux parents de définir leurs besoins vestimentaires (quotas) organisés par contextes (packs).

### Story 3.1 : Gestion des Packs Thématiques
**As a** Parent,
**I want** créer, activer et gérer des "Packs" de vêtements (ex: Été, Ski, Crèche),
**So that** je puisse organiser mes besoins et ne voir que ce qui est pertinent pour la saison ou le contexte actuel.

**Acceptance Criteria:**
1.  **Liste des Packs** : L'écran `/settings/packs` affiche tous les packs disponibles.
2.  **Pack par Défaut** : Un pack "Essentiels" (ou "Quotidien") existe par défaut et ne peut pas être supprimé.
3.  **Création** : Je peux créer un nouveau pack avec un Nom (ex: "Vacances Mer") et une icône/couleur optionnelle.
4.  **Activation/Désactivation** : Je peux activer ou désactiver un pack via un toggle. Seuls les packs actifs influenceront le calcul du Gap.
5.  **Exemple** : Si je désactive le pack "Ski", le dashboard ne doit plus me dire qu'il manque des combinaisons de ski.

**Technical Notes:**
*   Entity `Pack` (UUID id, String name, Boolean isActive, Boolean isSystem).

### Story 3.2 : Configuration de la Grille des Quotas
**As a** Parent,
**I want** définir combien de vêtements de chaque type je souhaite avoir (Quotas) pour mes packs actifs,
**So that** l'application sache quel est mon objectif de stock.

**Acceptance Criteria:**
1.  **Matrice de Saisie** : Sur le détail d'un pack (ou une vue globale), je vois la liste des types de vêtements.
2.  **Saisie des Quantités** : En face de chaque type, je peux saisir un nombre cible (ex: "7" pour Bodys dans le pack Essentiels).
3.  **Zéro par défaut** : Si rien n'est saisi, le quota est de 0.
4.  **Sauvegarde** : Les modifications sont sauvegardées (auto-save ou bouton dédié).
5.  **Contexte** : Ces quotas s'appliquent "par taille" (on simplifie : pas de quota spécifique 3M vs 6M pour le MVP, on veut 7 bodys quelle que soit la taille).

**Technical Notes:**
*   Entity `Quota` (UUID packId, UUID clothingTypeId, Integer quantity).
*   La clé unique est (packId, clothingTypeId).

---

## Epic 4 : Moteur de Gap Analysis & Dashboard
**Objectif** : Comparer l'inventaire réel avec les quotas définis pour identifier les manques.

### Story 4.1 : Algorithme de Calcul du Gap (Backend)
**As a** Système,
**I want** calculer la différence entre le stock possédé et les besoins cumulés des packs actifs,
**So that** je puisse déterminer le statut (Manquant, OK, Surplus) pour chaque type de vêtement.

**Acceptance Criteria:**
1.  **Entrées** : Prend en entrée un `Child` (pour sa taille actuelle) et la liste des `Packs` actifs.
2.  **Calcul du Besoin** : Pour chaque `ClothingType`, le Besoin Total = Somme des `Quotas` de ce type dans tous les packs actifs.
3.  **Calcul du Stock** : Récupère le nombre d'items de ce type dans l'inventaire du `Child` pour sa taille courante.
4.  **Résultat (Gap)** : `Gap = Stock - Besoin`.
5.  **Statuts** :
    *   `MISSING` (Rouge) si Gap < 0 (ex: Stock 4, Besoin 7 => -3).
    *   `SUFFICIENT` (Vert) si Gap == 0.
    *   `EXCESS` (Bleu/Gris) si Gap > 0.
6.  **Endpoint** : `GET /api/gap/analysis?childId=...` retourne une liste de DTOs avec ces infos.

### Story 4.2 : Dashboard "Gap-First" (Frontend)
**As a** Parent,
**I want** voir une vue synthétique des vêtements manquants dès l'ouverture de l'app,
**So that** je sache immédiatement ce que je dois acheter ou laver.

**Acceptance Criteria:**
1.  **Page d'Accueil** : Le Dashboard est la vue principale.
2.  **Priorité aux Manques** : Les items avec statut `MISSING` apparaissent en premier, mis en évidence (couleur rouge ou alerte).
3.  **Indicateurs** : Affiche pour chaque type : "4 / 7" (4 possédés sur 7 requis).
4.  **Filtrage Saison** : Un sélecteur de saison (Hiver/Été/Tout) permet de filtrer les types affichés (basé sur la saisonnalité du `ClothingType`).
5.  **Quick Action** : Clic sur un item manquant permet d'aller vers l'ajout rapide ou de voir le détail.

---

## Epic 5 : Shopping List (Extension)
**Objectif** : Transformer les manques en liste d'actions concrètes.

### Story 5.1 : Vue Liste de Courses
**As a** Parent en magasin,
**I want** une liste simple à cocher des articles manquants,
**So that** je puisse faire mes achats efficacement sans analyser tout le dashboard.

**Acceptance Criteria:**
1.  **Vue Dédiée** : Page `/shopping-list`.
2.  **Contenu** : Liste uniquement les items où Gap < 0.
3.  **Affichage** : "Bodys (3 manquants)", "Pyjamas (1 manquant)".
4.  **Interaction** : Case à cocher. Cocher un item le barre visuellement (mode "Checklist papier").
5.  **Persistence (Optionnel MVP)** : Idéalement, cocher ne supprime pas le manque tant qu'on n'a pas ajouté l'item à l'inventaire, mais pour l'UX "Magasin", on veut juste rayer temporairement.
