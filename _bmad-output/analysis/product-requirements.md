# PRD : Application de Gap Analysis Textile Enfant

**Version :** 1.2  
**Statut :** Validé (Incorpore les specs UX v1.1)  
**Auteur :** John (PM) & Sally (UX)

## 1. Objectifs et Contexte de fond

### 1.1 Objectifs (Goals)
* **Réduction de la charge mentale** : Offrir une vue immédiate des manques réels par enfant/taille/saison via un "Gap Dashboard".
* **Optimisation des achats** : Permettre d'anticiper les besoins à 3 mois (anticipation Vinted) grâce à la gestion des tailles futures.
* **Efficacité de saisie** : Réduire le temps d'inventaire grâce à un mode "Batch" (saisie à la chaîne) pour les lots.
* **Zéro gaspillage** : Éviter les doublons en connaissant son stock exact par saison.

### 1.2 Contexte de fond (Background Context)
L'application transforme un inventaire textile passif en un outil décisionnel. Contrairement à une simple liste, elle compare en temps réel le stock possédé à des quotas définis (besoins quotidiens + packs thématiques actifs comme "Ski" ou "Été").

---

## 2. Exigences (Requirements)

### 2.1 Exigences Fonctionnelles (FR)
* **FR1 : Profils Enfants** : Gestion du nom et de la taille actuelle (sans date de naissance). La taille doit être modifiable en un clic pour recalculer le Gap.
* **FR2 : Référentiel Saisonnier** : Les types de vêtements sont tagués par saison (❄️ Froid, ☀️ Chaud, Permanent).
* **FR3 : Packs Thématiques** : Création de groupes de besoins (ex: "Pack Mer") activables/désactivables pour ne pas polluer le dashboard hors saison.
* **FR4 : Configuration des Quotas** : Définition d'objectifs numériques par type d'article au sein du stock "Quotidien" ou d'un "Pack".
* **FR5 : Saisie en Mode Batch (Sally Update)** : Interface persistante permettant de saisir plusieurs articles à la suite sans fermer la modale, en mémorisant l'enfant, la saison et la taille.
* **FR6 : Gestion des Lots** : Possibilité d'ajouter une quantité (ex: lot de 5 bodies) en une seule action.
* **FR7 : Moteur de Gap Analysis** : Calcul automatique : `(Stock en taille T) - (Somme des quotas actifs) = Manquants`.
* **FR8 : Liste de Courses** : Vue consolidée des articles manquants, filtrable par saison (priorité au rouge/critique).
* **FR9 : Spécificités Linge de Nuit** : Support des attributs dynamiques comme le TOG pour les gigoteuses.

### 2.2 Exigences Non-Fonctionnelles (NFR)
* **NFR1 : Mobile-First PWA** : Interface optimisée pour un usage à une main (boutons larges, pas de clavier).
* **NFR2 : Performance** : Saisie d'un article en moins de 3 secondes en mode Batch.
* **NFR3 : Connectivité** : Utilisation avec connexion internet uniquement (pas de mode offline).
* **NFR4 : Flexibilité** : Usage de PostgreSQL JSONB pour ajouter des types de vêtements sans modifier le schéma.

---

## 3. Objectifs de l'interface utilisateur (Sally Design)

### 3.1 Vision UX
* **Dashboard "Gap-First"** : On affiche ce qu'il manque avant ce qu'on a.
* **Sélecteur de Saison** : Un toggle global (❄️/☀️) filtre l'ensemble de l'application.
* **Navigation** : Tab Bar inférieure (Dashboard, Inventaire, Ajouter, Configuration, Profil).

### 3.2 Écrans clés
1. **Gap Dashboard** : Liste de progression des quotas (ex: "Bonnets : 1/2").
2. **Quick Add (Batch Modal)** : Flux : Saison > Type > Quantité > Valider & Continuer.
3. **Gestion des Quotas** : Grille de saisie des objectifs par pack.

---

## 4. Hypothèses Techniques (Winston Architecture)
* **Backend** : Java 21 / Spring Boot 3.
* **Frontend** : React / Next.js (PWA).
* **Base de données** : PostgreSQL avec support JSONB pour les attributs personnalisés.
* **Architecture** : Hexagonale pour isoler le moteur de calcul du Gap.

---

## 5. Liste des Epics et Stories prioritaires

### Epic 1 : Socle et Profils
* **Story 1.1** : Setup Monorepo et Healthcheck.
* **Story 1.2** : CRUD Profil Enfant et modification de taille.

### Epic 2 : Inventaire et Mode Batch
* **Story 2.1** : Création de types de vêtements saisonnalisés.
* **Story 2.2** : Implémentation de la modale de saisie Batch (mémoire de contexte).

### Epic 3 : Quotas et Packs
* **Story 3.1** : Création de packs thématiques.
* **Story 3.2** : Configuration de la grille des quotas.

### Epic 4 : Moteur de Gap Analysis
* **Story 4.1** : Algorithme de calcul du Gap consolidé.
* **Story 4.2** : Vue Dashboard avec indicateurs de couleurs (Rouge/Orange/Vert).

---

## 6. Journal des modifications (Change Log)
| Date | Version | Description | Auteur |
| :--- | :--- | :--- | :--- |
| 13/01/2026 | 1.0 | Initialisation | John |
| 13/01/2026 | 1.2 | Ajout Mode Batch, Saisonnalité et Lots | John & Sally |