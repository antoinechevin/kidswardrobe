# Project Brief: Application d'inventaire de vêtements d'enfants

## Executive Summary

**Concept produit :** Application mobile-first d'analyse de manquants ("Gap Analysis") pour la gestion de garde-robe d'enfants, optimisée pour les achats anticipés sur Vinted.

**Problème principal :** Les parents de plusieurs enfants (dès 2+) font face à une charge mentale importante pour gérer les vêtements : savoir ce qui manque par taille/saison, anticiper les besoins 3 mois à l'avance pour tenir compte des délais Vinted (~3 semaines), et assurer l'exhaustivité (ne rien oublier, des pantalons chauds aux après-ski).

**Marché cible :** Parents de 2+ enfants utilisant activement Vinted, avec budget serré (400€/an/enfant) nécessitant une planification rigoureuse.

**Proposition de valeur clé :** Transformer la gestion mentale chaotique en "liste de courses dynamique" qui affiche instantanément ce qu'il MANQUE (pas ce qu'on a), par taille/genre/saison, permettant des achats Vinted ciblés et anticipés.

---

## Problem Statement

**État actuel et points de douleur :**
Gérer la garde-robe de plusieurs enfants avec un budget serré est un exercice mental épuisant. Les parents doivent constamment se souvenir de dizaines de questions : "Ai-je assez de pantalons chauds en 4 ans ?", "Manque-t-il un chapeau de soleil pour l'été prochain ?", "Les après-ski de l'an dernier vont-ils encore ?"

**Impact du problème (quantifié) :**
- **Charge cognitive excessive** : Impossible de garder en tête l'état de 30-40 types de vêtements × 3-4 tailles × 4 saisons
- **Risque critique** : Manquer de vêtements essentiels (pantalons chauds en hiver = problème majeur)
- **Gaspillage financier** : Achats en double ou achats urgents non-optimisés faute d'anticipation
- **Stress temporel** : Le délai Vinted de 3 semaines impose une anticipation de 3 MOIS pour les transitions saisonnières

**Pourquoi les solutions existantes échouent :**
- **Applications d'inventaire traditionnelles** : Montrent ce qu'on possède, pas ce qui manque → charge mentale supplémentaire pour calculer les besoins
- **Listes papier/Notes** : Non structurées, pas de vue par taille/saison, impossibles à maintenir à jour avec plusieurs enfants
- **Mémoire pure** : Tout simplement insuffisante avec plusieurs enfants d'âges différents et circulation des vêtements

**Urgence et importance de résoudre ce problème maintenant :**
Bien que la circulation des vêtements entre enfants réduise les besoins d'achat, la complexité de GÉRER cette circulation (quel enfant peut porter quoi, ce qui manque réellement malgré la transmission) reste élevée. Chaque transition saisonnière ratée coûte cher : achats d'urgence en magasin (vs Vinted) ou pire, enfants mal équipés. La solution doit exister AVANT les prochains changements de saison.

---

## Proposed Solution

**Concept et approche :**
Une application mobile-first qui transforme la gestion mentale de garde-robe en "liste de courses dynamique". L'utilisateur configure ses quotas (ex: "4 pantalons chauds taille 4 ans mixte") et l'app affiche instantanément : "⚠️ Manque 2 pantalons chauds taille 4 ans".

**Différenciateurs clés par rapport aux solutions existantes :**
1. **Vue "Manquants" vs "Inventaire"** : Affiche directement ce qu'il faut acheter, pas ce qu'on possède → élimine le calcul mental
2. **Organisation par Taille + Genre + Saison** : Stock générique (pas par enfant) reflétant la circulation réelle des vêtements
3. **Anticipation 3 mois intégrée** : Filtre saison permettant de voir facilement "printemps dans 3 mois" dès janvier
4. **Exhaustivité garantie** : Liste pré-définie de 30-40 types de vêtements incluant les oublis fréquents (après-ski, chapeau soleil, maillot)

**Pourquoi cette solution réussira là où d'autres ont échoué :**
- **Alignement parfait avec le workflow Vinted** : L'app devient le point de départ ("Que dois-je chercher ?") plutôt qu'un outil de vérification
- **Ajout rapide en masse** : Formulaire minimal (4 champs + quantité) permettant d'ajouter 100+ articles initialement puis des lots de 10-15 régulièrement
- **Zéro calcul mental** : Le système fait tout le travail de comparaison stock vs quotas

**Vision haut niveau du produit :**
Un assistant numérique qui remplace la mémoire humaine pour la gestion de garde-robe, permettant des achats Vinted sereins et anticipés, sans jamais manquer un vêtement essentiel.

---

## Target Users

### Primary User Segment: Parents Multi-Enfants Utilisateurs Vinted

**Profil démographique :**
- Parents de 2+ enfants d'âges variés (typiquement 0-6 ans)
- Budget vêtements serré : ~400€/an/enfant
- Utilisateurs actifs de Vinted pour l'essentiel des achats

**Comportements et workflows actuels :**
- Achats Vinted réguliers en lots de 10-15 articles
- Gestion mentale de l'inventaire (charge cognitive élevée)
- Anticipation approximative des besoins saisonniers
- Circulation des vêtements entre enfants selon taille/genre

**Besoins et points de douleur spécifiques :**
- **Besoin critique** : Savoir instantanément ce qui manque, sans calcul mental
- **Douleur majeure** : Oublier des catégories essentielles (après-ski, chapeau soleil) découvertes au dernier moment
- **Frustration** : Impossibilité de se souvenir de l'état du stock avec plusieurs enfants
- **Contrainte temporelle** : Devoir anticiper 3 mois à l'avance pour les transitions saisonnières

**Objectifs qu'ils cherchent à atteindre :**
- Réduire la charge mentale de gestion de garde-robe à zéro
- Ne jamais manquer d'un vêtement essentiel
- Optimiser les achats Vinted avec une liste précise
- Garantir l'exhaustivité (ne rien oublier)

---

## Goals & Success Metrics

### Business Objectives

- **Adoption utilisateur** : 50 familles actives dans les 3 premiers mois (validation du besoin réel)
- **Engagement** : 80% des utilisateurs consultent l'app au moins 1 fois par semaine (utilité confirmée)
- **Rétention** : 70% des utilisateurs actifs après 3 mois (solution durable)
- **Réduction charge mentale** : 90% des utilisateurs rapportent une diminution significative du stress de gestion de garde-robe

### User Success Metrics

- **Complétude inventaire** : Temps moyen pour atteindre 80+ articles dans l'inventaire < 30 minutes (ajout rapide validé)
- **Anticipation effective** : 75% des utilisateurs consultent la vue "prochaine saison" au moins 1 mois avant la transition
- **Exhaustivité** : 85% des utilisateurs utilisent au moins 25 des 30-40 types de vêtements pré-définis (liste complète validée)
- **Succès Vinted** : 80% des utilisateurs rapportent des achats Vinted plus ciblés et efficaces

### Key Performance Indicators (KPIs)

- **KPI Clé 1 - Temps consultation app** : Moyenne < 2 minutes par session (consultation rapide "liste de courses")
- **KPI 2 - Fréquence d'ajout** : Moyenne 2-3 sessions d'ajout par mois (correspond au rythme d'achat Vinted)
- **KPI 3 - Taux d'utilisation vue "Manquants"** : 90%+ des sessions incluent consultation de la vue manquants (fonctionnalité cœur utilisée)
- **KPI 4 - Satisfaction** : NPS (Net Promoter Score) > 50 après 1 mois d'utilisation

---

## MVP Scope

### Core Features (Must Have)

- **Vue "Manquants" par Taille/Saison** : Interface principale affichant "⚠️ Manque X [type] taille Y [genre]" avec filtres Taille/Genre/Saison. **Affichage prioritaire des essentiels** (pantalons, t-shirts, pulls) avant les catégories exceptionnelles. C'est la fonctionnalité cœur - sans elle, l'app ne sert à rien.

- **Ajout Rapide avec Quantité** : Formulaire minimal (Type/Taille/Genre/Saison + champ Quantité) permettant l'ajout de 100+ articles initialement puis lots de 10-15. Chaque seconde gagnée se multiplie par 100+.

- **Configuration des Quotas** : Interface "Je veux X [type] en taille Y [genre]" avec suggestions de quotas par défaut **spécifiques à chaque article** selon l'âge (ex: 8 t-shirts 1-3 ans vs 5 t-shirts 3-6 ans, 1 maillot de bain). Sans quotas, impossible de calculer les manquants.

- **Liste Pré-définie Exhaustive avec Groupes** : 30-40 types de vêtements pré-configurés organisés en groupes :
  - **Essentiel** : pantalons, t-shirts, pulls, sous-vêtements, chaussettes (quotidien)
  - **Neige** : après-ski, combinaison, gants, bonnet (hiver ponctuel)
  - **Soleil** : chapeau soleil, lunettes (été ponctuel)
  - **Bain** : maillot de bain, serviette (été ponctuel)
  
  Garantit l'exhaustivité = valeur clé pour ne rien oublier.

- **Organisation par Taille + Genre + Saison** : Stock générique non lié aux enfants, organisé par critères de réutilisation. Correspond au workflow réel (habits circulent entre enfants).

### Out of Scope for MVP

- Import automatique Vinted (RGPD + catégorisation semi-auto)
- Alertes/suggestions d'achat proactives
- Types d'habits personnalisés (au-delà de la liste pré-définie)
- Tracking état des habits (Commandé/En lavage/Prêt/Passé)
- Budget tracking intégré
- Reconnaissance automatique IA/Photo
- **Filtrage par groupe de catégories** (essentiel/neige/soleil/bain) - Post-MVP

### MVP Success Criteria

Le MVP sera considéré comme réussi si :
- Un parent peut ajouter son inventaire initial (100+ articles) en < 30 minutes
- La vue "Manquants" affiche instantanément ce qu'il faut acheter, **avec les essentiels en priorité**
- Les quotas peuvent être configurés en < 5 minutes avec suggestions adaptées par article
- L'utilisateur peut filtrer par saison "actuelle + 2" pour anticiper 3 mois à l'avance
- 80%+ des utilisateurs testeurs rapportent une réduction de charge mentale

---

## Post-MVP Vision

### Phase 2 Features (Priorité Haute - Post-MVP Proche)

- **Import Vinted** : Import données RGPD Vinted + catégorisation semi-automatique. Nécessite développement du parser format Vinted + mapping intelligent + workflow de révision. Travail manuel de catégorisation post-import acceptable. Timeline estimée : 2-4 semaines après MVP.

- **Filtrage par groupe de catégories** : Permettre d'afficher uniquement les "Essentiels", "Neige", "Soleil", ou "Bain" dans la vue Manquants. Timeline estimée : 1-2 semaines après MVP.

### Phase 3 Features (Priorité Moyenne)

- **Alertes/Suggestions d'Achat** : "Attention, il te manque 3 pantalons chauds 4 ans pour cet hiver" avec calcul d'urgence basé sur saison. Nécessite système de notification + calcul d'urgence. Timeline estimée : 1-2 mois après MVP.

### Phase 4+ Features (Priorité Basse)

- **Types d'Habits Personnalisés** : Ajout de nouveaux types au-delà de la liste pré-définie. Nécessite interface d'ajout + gestion des types custom dans quotas. Timeline estimée : 3+ mois après MVP.

### Long-term Vision (Un à deux ans)

Une plateforme complète de gestion de garde-robe familiale qui :
- Élimine complètement la charge mentale de gestion vestimentaire
- S'intègre parfaitement avec les plateformes de seconde main (Vinted, LeBonCoin, etc.)
- Devient l'assistant personnel indispensable pour toute famille nombreuse
- Potentiel de monétisation : Premium features (import auto avancé, analytics, multi-famille)

### Expansion Opportunities

- **Partage inter-familles** : Système de don/échange entre familles avec enfants d'âges compatibles
- **Communauté** : Forum/groupes de parents pour conseils, bons plans Vinted, retours d'expérience
- **Analytics avancés** : Prédiction des besoins basée sur historique, suggestions d'optimisation budget
- **Intégrations tierces** : LeBonCoin, autres plateformes de seconde main, magasins physiques

---

## Technical Considerations

### Platform Requirements

- **Target Platforms** : Mobile-first (iOS et Android via PWA), avec consultation desktop
- **Browser/OS Support** : 
  - iOS 14+ (Safari)
  - Android 10+ (Chrome)
  - Desktop moderne (Chrome, Firefox, Safari) en responsive
- **Performance Requirements** : 
  - Vue "Manquants" : affichage < 1 seconde même avec 200+ articles
  - Ajout article : sauvegarde instantanée (< 500ms)
  - Filtres : application immédiate sans lag

### Technology Preferences

- **Frontend** : 
  - PWA (Progressive Web App) pour déploiement cross-platform
  - Framework moderne (React/Vue) léger
  - Tailwind CSS pour styling rapide
  - Développement via vibe coding (v0.dev, Cursor, ou similaire)
  
- **Backend** : 
  - **Java 17+ avec Spring Boot 3.x**
  - **Architecture Hexagonale (Ports & Adapters)** pour séparation claire domaine/infrastructure
  - Spring Data JPA pour persistance
  - Spring Security pour authentification
  - API REST bien structurée
  
- **Database** : 
  - **PostgreSQL** (relationnel robuste)
  - Structure normalisée avec tables Articles, Quotas, Catégories
  - Indexes optimisés pour requêtes par taille/genre/saison
  
- **Hosting/Infrastructure** : 
  - Frontend : Vercel/Netlify (gratuit)
  - Backend : Heroku free tier, Railway, ou Render
  - Base de données : PostgreSQL gratuit inclus
  - **Conteneurisation Docker** (facilite déploiement)

### Architecture Considerations

- **Repository Structure** : 
  - Monorepo ou séparation frontend/backend (à définir)
  - **Structure hexagonale backend** :
    - `domain/` : Entités métier pures, ports (interfaces), logique métier
    - `application/` : Use cases, services applicatifs
    - `infrastructure/` : Adapters (REST controllers, JPA repositories, config)
  
- **Service Architecture** : 
  - **Architecture Hexagonale (Ports & Adapters)**
  - **Domain** : Modèle métier pur (Article, Quota, Catégorie, règles de calcul manquants)
  - **Ports primaires** : Use cases (CalculerManquants, AjouterArticle, ConfigurerQuota)
  - **Ports secondaires** : Interfaces de persistence, services externes
  - **Adapters REST** : Controllers exposant l'API
  - **Adapters JPA** : Implémentation persistence
  - DTOs pour communication API
  
- **Integration Requirements** : 
  - Spring Security avec JWT pour authentification
  - CORS configuré pour communication frontend/backend
  - Validation Bean Validation (JSR-380)
  
- **Security/Compliance** : 
  - Spring Security avec authentification JWT
  - HTTPS obligatoire en production
  - Hashage des mots de passe (BCrypt)
  - Validation des entrées côté serveur

### Architecture Spéciale Portfolio

- **Architecture avancée** : Hexagonale démontre maîtrise des design patterns
- **CI/CD** : GitHub Actions pour build/tests/déploiement automatique
- **Tests complets** :
  - Tests unitaires domaine (logique métier pure)
  - Tests d'intégration adapters
  - Tests API avec MockMvc
- **Documentation** : Swagger/OpenAPI intégré
- **Monitoring** : Spring Boot Actuator
- **Code Quality** : SonarQube ou similaire

---

## Constraints & Assumptions

### Constraints

- **Budget** : Projet personnel portfolio → coûts hébergement minimaux (objectif : tier gratuits ou <10€/mois)
  
- **Timeline** : 
  - MVP fonctionnel en 2-3 mois (développement solo temps partiel)
  - Priorité sur qualité du code (portfolio) vs rapidité
  
- **Resources** : 
  - Développement solo backend Java/Spring (expertise principale)
  - Frontend via vibe coding (génération AI)
  - Pas de designer professionnel (UI fonctionnelle via templates)
  - Temps limité (projet à côté d'autres engagements)
  
- **Technical** : 
  - Architecture hexagonale obligatoire (démonstration compétences)
  - Stack backend imposée : Java 17+, Spring Boot 3.x, PostgreSQL
  - Hébergement gratuit/low-cost contraignant les choix infrastructure
  - PWA pour éviter complexité développement apps natives

### Key Assumptions

- Les utilisateurs cibles (parents 2+ enfants utilisant Vinted) existent et ont ce besoin
- L'ajout manuel de 100+ articles initialement est acceptable si rapide (<30 min)
- Une liste pré-définie de 30-40 types couvre 90%+ des besoins réels
- Les utilisateurs préfèrent voir ce qui MANQUE plutôt que ce qu'ils ont
- L'anticipation 3 mois est suffisante pour gérer les transitions saisonnières
- Une PWA est suffisante vs apps natives iOS/Android pour le MVP
- L'organisation par Taille+Genre (pas par enfant) correspond au modèle mental des utilisateurs
- Les quotas par défaut proposés seront suffisamment précis pour la majorité des cas
- L'absence d'import Vinted automatique au MVP n'est pas bloquante
- Le vibe coding peut générer un frontend de qualité suffisante avec bons prompts

---

## Risks & Open Questions

### Key Risks

- **Risque adoption** : Bien que le besoin existe dès 1-2 enfants (charge mentale + anticipation Vinted), trouver des early adopters reste un défi. _Impact_ : Difficulté à valider le produit. _Mitigation_ : Commencer par votre propre usage (2 enfants, bientôt 3) + 5-10 familles proches.

- **Complexité de la liste exhaustive** : Définir les 30-40 types de vêtements et les groupes (essentiel/neige/soleil/bain) de manière pertinente pour tous. _Impact_ : Liste non adaptée = perte de valeur "exhaustivité". _Mitigation_ : Co-construction avec utilisateurs testeurs dès le début.

- **Quotas par défaut inadaptés** : Les suggestions de quotas (ex: "4 pantalons", "6 t-shirts") pourraient ne pas correspondre aux besoins réels. _Impact_ : Perte de temps configuration + frustration utilisateur. _Mitigation_ : Recherche préalable + possibilité de personnaliser facilement.

- **Performance avec gros inventaires** : Avec 200-400 articles, les filtres et calculs pourraient ralentir. _Impact_ : UX dégradée. _Mitigation_ : Optimisations requêtes PostgreSQL + indexes bien pensés + tests de charge.

- **Cohérence frontend/backend avec vibe coding** : Génération AI du frontend peut créer des incohérences avec l'architecture hexagonale backend. _Impact_ : Code mal structuré, difficultés d'intégration API. _Mitigation_ : Prompts bien construits, revue systématique du code généré, refactoring si nécessaire.

### Open Questions

- **Quel outil de vibe coding** : v0.dev, Cursor, Claude Projects, ou autre ? (Qualité génération vs facilité intégration backend)

- **Structure exacte de la liste de types** : Quels sont précisément les 30-40 types de vêtements et comment les organiser en groupes ?

- **Quotas par défaut source fiable** : Où trouver des données sur les besoins standard par âge/type ? (Parents expérimentés ? Études ? Essai-erreur ?)

- **Hébergement backend Spring Boot gratuit** : Heroku, Railway, Render - quelle solution est la plus stable et pérenne ?

- **Authentification MVP** : Simple email/password suffit, ou faut-il OAuth social (Google) pour faciliter adoption ?

- **Multi-device** : L'utilisateur ajoute sur mobile mais consulte parfois sur desktop - synchronisation temps réel nécessaire ou acceptable avec délai ?

### Areas Needing Further Research

- **Catalogues de vêtements enfants** : Pour constituer la liste exhaustive des types (Vertbaudet, H&M Kids, etc.)

- **Besoins quantitatifs standards** : Combien de pantalons/t-shirts par âge ? (Forums parents, blogs, groupes Facebook)

- **Hébergement gratuit Spring Boot** : Comparer Railway vs Render vs alternatives récentes

- **Best practices vibe coding pour PWA** : Comment structurer les prompts pour générer un frontend cohérent avec API REST hexagonale

---

## Appendices

### A. Research Summary

**Sources des insights :**
- Session de brainstorming complète (12 janvier 2026) utilisant techniques :
  - Five Whys : Exploration du besoin profond (anticipation 3 mois, charge mentale)
  - Assumption Reversal : Découverte clé "Gap Analysis vs Inventaire"
  - Role Playing : Validation workflow Vinted
  - Morphological Analysis : Catégorisation habits par âge
  - Forced Relationships : Évaluation budget (hors scope MVP)

**Principales découvertes :**
- Le vrai besoin n'est pas "faire un inventaire" mais "réduire la charge mentale quand je suis sur Vinted"
- L'anticipation n'est pas de 3 semaines mais de **3 MOIS** (ex: janvier = préparer le printemps)
- Budget = hors scope (manquer d'habits est grave, dépasser le budget n'est pas grave)
- Organisation par TAILLE + GENRE, pas par enfant (les habits circulent)

**Contexte utilisateur primaire :**
- 2 enfants actuellement (3ème en route)
- Besoin déjà présent avec 2 enfants (contrairement à l'hypothèse initiale "3+ enfants")
- Expérience réelle avec workflow Vinted (lots de 10-15 articles, délai 3 semaines)

### B. Stakeholder Input

**Utilisateur principal (Parent testeur)** :
- Validation du besoin "Gap Analysis" vs inventaire traditionnel
- Confirmation délai Vinted 3 semaines + anticipation 3 mois nécessaire
- Importance exhaustivité (ne rien oublier : après-ski, chapeau soleil, maillot)
- Priorité rapidité ajout > richesse de données
- Validation modèle "Stock générique par taille/genre"

### C. References

**Documents de brainstorming :**
- `brainstorming-session-results.md` - Session complète 12 janvier 2026

**Ressources à explorer (recherche future) :**
- Catalogues vêtements enfants : Vertbaudet, H&M Kids, Kiabi, etc.
- Forums parents : Doctissimo, Magic Maman, Reddit r/Parenting
- Communautés Vinted parents
- Blogs parentalité et gestion budgétaire

---

## Next Steps

### Immediate Actions

1. **Valider la liste exhaustive des types de vêtements** (30-40 types) par recherche catalogues + discussion avec parents expérimentés

2. **Définir les quotas par défaut** pour chaque type/âge par recherche + itération avec utilisateurs testeurs

3. **Choisir l'outil de vibe coding** (v0.dev, Cursor, autre) et faire des tests rapides de génération PWA

4. **Sélectionner solution hébergement backend** Spring Boot gratuit (Railway vs Render) et tester déploiement

5. **Créer le PRD détaillé** avec ce Project Brief comme base

### PM Handoff

Ce Project Brief fournit le contexte complet pour l'**Application d'inventaire de vêtements d'enfants orientée Gap Analysis**. 

**Prochaine étape recommandée :** Créer le PRD (Product Requirements Document) en mode interactif, en utilisant ce brief comme fondation. Le PRD détaillera :
- Les requirements fonctionnels et non-fonctionnels précis
- Les user stories et acceptance criteria
- L'architecture technique détaillée (hexagonale backend Java/Spring)
- Les epics de développement séquencés

**Pour le Product Manager :** Veuillez démarrer en 'PRD Generation Mode', réviser ce brief en profondeur et travailler avec l'utilisateur pour créer le PRD section par section selon le template, en demandant toute clarification nécessaire ou en suggérant des améliorations.

---

*Document créé le 12 janvier 2026 par Business Analyst Mary*
