# Project Brief: Application d'Inventaire de Textile Enfant (v2)

**Date :** 13 Janvier 2026
**Auteur :** Business Analyst Mary (BMad Method)
**Statut :** Validé

## 1. Executive Summary

**Concept produit :** Application mobile-first d'analyse de manquants ("Gap Analysis") pour la gestion de la garde-robe et du linge de nuit des enfants, optimisée pour les achats anticipés sur Vinted.

**Problème principal :** La charge mentale liée à la gestion textile de plusieurs enfants : savoir ce qui manque réellement par taille/contexte, anticiper les besoins 3 mois à l'avance (délais Vinted), et éviter les doublons inutiles ou les oublis critiques.

**Proposition de valeur clé :** Un inventaire **adaptatif** qui génère une "liste de courses intelligente" basée sur des quotas personnalisables. L'utilisateur peut ajouter ses propres catégories (ex: sandales spécifiques, tenues de sport) pour coller à sa réalité quotidienne.

## 2. Problem Statement

**État actuel et points de douleur :**
L'organisation actuelle est souvent rigide ou purement mémorielle. Les parents achètent souvent "au coup de cœur" sur Vinted sans savoir si le besoin quotidien est couvert ou si le stock pour les vacances (ski/plage) est prêt. L'absence de distinction entre le "manteau de tous les jours" et la "combinaison de ski" fausse l'analyse des besoins.

**Impact :**
- **Surconsommation** : Achat de vêtements redondants.
- **Stress de dernière minute** : Réaliser qu'il manque des sandales la veille du départ en été.
- **Dette textile** : Stockage de vêtements inutiles qui prennent de la place.

## 3. Proposed Solution

### Taxonomie Intelligente (Le "Quoi" et le "Quand")

L'application repose sur deux axes de classification pour une Gap Analysis précise :

**A. Les Types (Le "Quoi" - Liste extensible par l'utilisateur) :**
- **Hauts** : T-shirt, Pull, Chemise, Gilet...
- **Bas** : Pantalon, Short, Jupe, Legging...
- **Chaussures** : Baskets, Bottes, Sandales, Après-ski...
- **Nuit & Linge** : Pyjama, Gigoteuse, Drap-housse, Couette...

**B. Les Contextes d'Usage (Le "Quand" - Filtres d'analyse) :**
1. **Quotidien (Saisonnier)** : Vêtements de tous les jours (subdivisé par Été / Hiver / Mi-saison). *Note : Les manteaux d'école vont ici.*
2. **Nuit** : Tout ce qui concerne le sommeil (vêtements + linge de lit par taille).
3. **Grand Froid / Montagne** : Usage exceptionnel technique (Ski, après-ski, gants).
4. **Plage / Été Intense** : Usage spécifique (Maillots, UV, chaussures de plage).
5. **Cérémonie & Sport** : Besoins ponctuels, habillés ou associatifs.

## 4. Target Users

- **Utilisateur Primaire :** Parents de 2 enfants ou plus (gestion multi-enfants complexe).
- **Profil :** Utilisateurs actifs de Vinted, cherchant à optimiser leur budget et leur temps de stockage.

## 5. MVP Scope

### Fonctionnalités Core (Must Have)
- **Dashboard Gap Analysis** : Vue immédiate des articles manquants par enfant/taille/contexte.
- **Gestion Dynamique des Types** : Possibilité pour l'utilisateur de créer un nouveau type d'article s'il n'existe pas par défaut (ex: "Sandales d'été").
- **Système de Quotas par Contexte** : Définir des besoins différents (ex: 5 pantalons "Quotidien" vs 1 pantalon "Montagne").
- **Suivi du Linge de Nuit** : Gestion des gigoteuses et draps par dimensions/tailles.
- **Saisie Rapide "Vinted-Friendly"** : Ajout d'un article en quelques secondes après un achat ou une réception.

### Hors Scope MVP
- Partage d'inventaire entre conjoints (V2).
- Reconnaissance d'image pour l'identification automatique des vêtements.
- Suggestion de prix de revente basée sur le marché.

## 6. Technical Considerations

- **Architecture** : Hexagonale (Backend Java/Spring Boot) pour isoler la logique métier du moteur de calcul des manques.
- **Frontend** : PWA (Progressive Web App) mobile-first pour une accessibilité rapide sans installation complexe.
- **Base de données** : Schéma flexible pour supporter les types personnalisés sans migrations coûteuses.

## 7. Next Steps

1. **Handoff au Product Manager (PM)** pour la création du PRD détaillé.
2. **Définition des Quotas par défaut** pour aider les nouveaux utilisateurs.
3. **Maquettage des écrans clés** (Dashboard de manque et formulaire d'ajout rapide).

---
*Document généré par Mary, BMad Business Analyst.*