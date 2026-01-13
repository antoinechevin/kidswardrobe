# Brainstorming Session Results

**Session Date:** 2026-01-12
**Facilitator:** Business Analyst Mary
**Participant:** Antoine
**Topic:** Application d'inventaire de vêtements d'enfants

---

## Executive Summary

**Session Goals:** Définir les fonctionnalités MVP d'une application mobile-first pour gérer l'inventaire de vêtements d'enfants, optimiser les achats sur Vinted, et réduire la charge mentale parentale.

**Techniques Used:**
- Five Whys (exploration du besoin profond)
- Assumption Reversal (challenge des hypothèses)
- Role Playing (validation des scénarios d'usage)
- Morphological Analysis (catégorisation des habits par âge)
- Forced Relationships (exploration budget/priorités)

**Total Ideas Generated:** 15+ fonctionnalités explorées

**Key Themes Identified:**
1. **Gap Analysis vs Inventaire Traditionnel** - L'app doit montrer ce qui MANQUE, pas ce qui existe
2. **Anticipation Critique** - Achats Vinted nécessitent 3 semaines + besoin de planifier 3 mois à l'avance
3. **Exhaustivité comme Valeur** - Ne rien oublier (après-ski, chapeau soleil, maillot) est crucial
4. **Rapidité d'Ajout** - Ajout en masse pour les lots de 10-15 articles
5. **Contexte Multi-Enfants** - Gestion complexe avec 3-4 enfants, genres mixtes, passage d'habits

---

## Technique Sessions

### Five Whys - Comprendre le Besoin Profond
**Duration:** 15 minutes

**Ideas Generated:**
1. **Besoin initial:** Savoir quoi acheter pour la prochaine saison
2. **Pourquoi important:** Éviter de manquer d'habits (critique) + éviter les doublons
3. **Contrainte Vinted:** Délai de 3 semaines entre achat et disponibilité (réception + lavage + séchage)
4. **Contrainte Budget:** 400€/an/enfant → Vinted indispensable vs magasin
5. **Charge Mentale:** Difficile de se souvenir avec 3-4 enfants → "Ai-je assez de pantalons chauds en 4 ans?"

**Insights Discovered:**
- Le vrai problème n'est pas "faire un inventaire" mais "réduire la charge mentale quand je suis sur Vinted"
- L'anticipation n'est pas de 3 semaines mais de **3 MOIS** (ex: janvier = préparer le printemps)
- Budget = hors scope (manquer d'habits est grave, dépasser le budget n'est pas grave)

**Notable Connections:**
- Délai Vinted × Anticipation saisonnière = Besoin de planifier 3 mois à l'avance minimum
- Multi-enfants × Budget serré × Délai = Stress maximum à réduire

---

### Assumption Reversal - Challenge des Hypothèses
**Duration:** 10 minutes

**Ideas Generated:**
1. **Challenge:** "Et si on n'inventoriait que les catégories critiques?"
   - **Résultat:** Rejeté - Besoins ponctuels (voyage, neige) rendent tout potentiellement critique
   
2. **Challenge:** "Et si l'interface principale n'était pas une liste mais un tableau de bord par enfant?"
   - **Résultat:** Partiellement validé - Mais pas par enfant, par TAILLE (stock générique)
   
3. **Découverte majeure:** "Savoir ce que j'ai m'intéresse beaucoup moins que savoir ce qu'il me MANQUE"
   - **Impact:** Redéfinition complète du projet = Gap Analysis System

**Insights Discovered:**
- L'interface doit être orientée "manquants" pas "inventaire"
- Organisation par TAILLE + GENRE, pas par enfant (les habits circulent entre enfants)
- Le modèle mental est: "Stock générique par taille/genre" → "Calcul automatique des manquants"

---

### Role Playing - Validation des Scénarios
**Duration:** 8 minutes

**Scenario 1: "Sur Vinted, bonne affaire"**
- **Hypothèse testée:** L'utilisateur consulte l'app depuis Vinted
- **Résultat:** Workflow réel = App d'abord → Liste manquants → Recherche Vinted ciblée
- **Insight:** L'app est une "liste de courses dynamique" qui guide les achats Vinted

**Scenario 2: "Changement de saison imminent"**
- **Hypothèse testée:** Vue spéciale "Prochaine saison"
- **Résultat:** Anticipation de 3 MOIS confirmée (janvier = préparer printemps)
- **Insight:** Les catégories saisonnières sont critiques (pulls, t-shirts col roulé, pantalons chauds)

---

### Morphological Analysis - Catégorisation par Âge
**Duration:** 12 minutes

**Dimensions Explorées:**

**Dimension 1: Tranches d'Âge**
- 0-1 an (bébé)
- 1-3 ans (petit enfant)
- 3-6 ans (enfant)
- 6+ ans (hors scope pour MVP)

**Dimension 2: Types d'Habits Spécifiques**
- **0-3 ans uniquement:** Bodies, gigoteuses
- **Disparition vers 3 ans:** Bodies et gigoteuses
- **3-6 ans:** Habits "classiques adultes miniatures"

**Dimension 3: Quotas Variables**
- **1-3 ans:** Plus d'habits nécessaires (se salit plus) → ex: 8 t-shirts
- **3-6 ans:** Moins d'habits nécessaires (plus propre) → ex: 5 t-shirts

**Dimension 4: Exhaustivité des Catégories**
Liste complète nécessaire incluant:
- Courants: Pantalons, pulls, t-shirts, shorts
- Saisonniers: Chapeau soleil, après-ski, maillot de bain
- Spécifiques: Chaussons école, tabliers, etc.

**Insights Discovered:**
- L'app doit avoir une liste PRÉ-DÉFINIE exhaustive (30-40 types)
- Les quotas par défaut doivent varier selon l'âge
- Possibilité d'ajouter des types personnalisés = pas prioritaire MVP

---

### Forced Relationships - Budget × Manquants
**Duration:** 5 minutes

**Concept Testé:** Budget tracking intégré à la liste de manquants

**Résultat:** Rejeté pour MVP
- Budget n'est pas une contrainte dure
- La priorité est de ne jamais manquer d'habits
- Acheter neuf = non rentable, Vinted = toujours rentable

**Insight:** Focus 100% sur l'anticipation des manques, pas sur l'optimisation budgétaire

---

## Contexte Utilisateur - Insights Critiques

### Situation Familiale Réelle
- **3 enfants actuels** (4ème en route)
- **Enfant 1** (fille aînée): Tout à construire, rien avant elle
- **Enfant 2** (garçon milieu): Gros besoin - habits filles pas adaptés après 3 ans
- **Enfant 3** (fille 1 an): Stock 0-3 ans quasi complet via transmission

**Implication pour l'App:**
- Focus principal: **Tranches 3-6 ans et plus**
- Gestion genre cruciale (mixte vs fille vs garçon)
- Transmission d'habits = complexe avec 2 filles + 1 garçon au milieu

### Workflow d'Achat Actuel
1. Identification du besoin (mental, charge cognitive élevée)
2. Recherche ciblée sur Vinted
3. Achat (souvent en lots de 10-15 articles)
4. Réception (délai variable)
5. Lavage + séchage (quelques jours)
6. **Disponibilité ~3 semaines après achat**

**Implication:** Anticipation 3 mois obligatoire pour changements saisonniers

---

## Idea Categorization

### Immediate Opportunities (MVP Core)

1. **Vue "Manquants" par Taille/Saison**
   - Description: Interface principale montrant "❌ Manque 2 pantalons chauds taille 4 ans"
   - Why immediate: C'est la fonctionnalité cœur, sans elle l'app ne sert à rien
   - Resources needed: Modèle de données (Stock + Quotas), UI mobile-first

2. **Ajout Rapide avec Quantité**
   - Description: Formulaire minimal (Type/Taille/Genre/Saison) + champ Quantité pour lots
   - Why immediate: Ajout de 100+ articles au début + lots de 10-15 articles réguliers
   - Resources needed: Form mobile optimisé, validation rapide

3. **Configuration des Quotas**
   - Description: "Je veux 4 pantalons chauds en taille 4 ans mixte"
   - Why immediate: Sans quotas, impossible de calculer les manquants
   - Resources needed: Interface de config simple, suggestions par défaut

4. **Liste Pré-définie Exhaustive**
   - Description: 30-40 types d'habits pré-configurés (pantalons, pulls, chapeau soleil, après-ski, maillot, etc.)
   - Why immediate: Garantir l'exhaustivité = valeur clé pour ne rien oublier
   - Resources needed: Base de données de types, catégorisation par âge

5. **Organisation par Taille + Genre + Saison**
   - Description: Stock générique non lié aux enfants, organisé par critères de réutilisation
   - Why immediate: Modèle correspondant au workflow réel (habits circulent entre enfants)
   - Resources needed: Schéma DB adapté, filtres UI efficaces

### Future Innovations (Post-MVP)

1. **Import Vinted (Priorité Haute - Post-MVP Proche)**
   - Description: Import données RGPD Vinted + catégorisation semi-automatique
   - Development needed: Parser format Vinted (à découvrir), mapping intelligent, workflow de révision
   - Timeline estimate: 2-4 semaines après MVP
   - Note: Travail manuel de catégorisation post-import acceptable

2. **Alertes/Suggestions d'Achat (Priorité Moyenne)**
   - Description: "Attention, il te manque 3 pantalons chauds 4 ans pour cet hiver"
   - Development needed: Système de notification, calcul d'urgence basé sur saison
   - Timeline estimate: 1-2 mois après MVP

3. **Types d'Habits Personnalisés (Priorité Basse)**
   - Description: Ajout de nouveaux types au-delà de la liste pré-définie
   - Development needed: Interface d'ajout, gestion des types custom dans quotas
   - Timeline estimate: 3+ mois après MVP

### Moonshots (Long-Terme ou Hors Scope)

1. **Tracking État des Habits**
   - Description: Commandé / En lavage / Prêt / Passé à l'enfant suivant
   - Transformative potential: Visibilité complète du cycle de vie
   - Challenges: Trop de friction pour l'ajout, charge cognitive augmentée
   - Note: Évalué à 1/5 par l'utilisateur

2. **Budget Tracking Intégré**
   - Description: Suivi des dépenses, priorisation dans le budget
   - Transformative potential: Optimisation financière
   - Challenges: Budget n'est pas une contrainte dure, ajoute de la complexité inutile
   - Note: Rejeté par l'utilisateur

3. **Reconnaissance Automatique (IA/Photo)**
   - Description: Scanner l'étiquette ou prendre une photo pour ajout automatique
   - Transformative potential: Rapidité d'ajout maximale
   - Challenges: Complexité technique élevée, temps de traitement (contradictoire avec rapidité recherchée)
   - Note: Rejeté pour MVP

### Insights & Learnings

1. **Gap Analysis > Inventaire Traditionnel**
   - Insight: L'utilisateur ne veut pas "voir ce qu'il a" mais "voir ce qu'il lui MANQUE"
   - Description: Changement de paradigme fondamental dans la conception
   - Implications: UI orientée "manquants", calcul automatique stock vs quotas, interface de type "liste de courses"

2. **Anticipation = 3 Mois, pas 3 Semaines**
   - Insight: Le délai Vinted de 3 semaines n'est que la partie visible. L'anticipation réelle est de 3 MOIS pour les transitions saisonnières.
   - Description: En janvier, on prépare le printemps (avril). En octobre, l'hiver (janvier).
   - Implications: Les vues saisonnières doivent permettre de voir "saison actuelle + 2" facilement

3. **Exhaustivité > Précision**
   - Insight: Mieux vaut une liste exhaustive avec approximations qu'une liste précise mais incomplète
   - Description: Oublier les après-ski ou le chapeau soleil est pire que d'avoir un quota imprécis de t-shirts
   - Implications: Liste pré-définie de 30-40 types minimum dès le MVP

4. **Rapidité > Richesse de Données**
   - Insight: L'utilisateur ajoutera 100+ articles au début, puis régulièrement des lots de 10-15 articles
   - Description: Chaque seconde gagnée sur l'ajout se multiplie par 100+. Photos, IA, prix, marque = friction inutile.
   - Implications: Formulaire minimal (4 champs + quantité), pas de champs optionnels tentants

5. **Stock Générique > Par Enfant**
   - Insight: Les habits circulent entre enfants selon taille et genre, pas selon "propriétaire"
   - Description: Une fille peut porter des habits mixtes du garçon. Le garçon peut porter certains habits de sa grande sœur.
   - Implications: Modèle par Taille+Genre, pas par Enfant. Le "flux" est géré mentalement par l'utilisateur.

6. **3-4 Enfants = Complexité Exponentielle**
   - Insight: Avec 3-4 enfants d'âges différents, la charge cognitive est telle qu'un système externe devient indispensable
   - Description: "Ai-je assez de pantalons chauds en 4 ans?" devient impossible à répondre de tête
   - Implications: L'app remplace la mémoire, pas un système de gestion élaboré

---

## Action Planning

### Top 3 Priority Ideas

#### #1 Priority: Vue "Manquants" - Interface Principale
- **Rationale:** Sans cette vue, l'app n'a aucune valeur. C'est le cœur du produit.
- **Next steps:**
  1. Définir le modèle de données (Stock, Quotas, Calcul Manquants)
  2. Designer l'interface mobile-first (filtres Taille/Saison/Genre)
  3. Implémenter le calcul dynamique manquants
- **Resources needed:**
  - Backend: API REST Java Spring (création tables Stock + Quotas)
  - Frontend: PWA React/Vue avec filtres performants
  - Design: Wireframes mobile pour validation rapide
- **Timeline:** Sprint 1-2 du développement

#### #2 Priority: Ajout Rapide avec Quantité
- **Rationale:** L'utilisateur doit pouvoir ajouter 100+ articles rapidement au début, puis des lots de 10-15 régulièrement
- **Next steps:**
  1. Créer formulaire minimal (Type/Taille/Genre/Saison/Quantité)
  2. Optimiser pour mobile (gros boutons, peu de scroll)
  3. Implémenter l'ajout en masse (1 form × quantité)
- **Resources needed:**
  - Frontend: Form mobile avec validation instantanée
  - Backend: Endpoint POST bulk-friendly
  - UX: Tests utilisateur pour confirmer la rapidité
- **Timeline:** Sprint 2-3 du développement

#### #3 Priority: Liste Exhaustive de Types d'Habits
- **Rationale:** L'exhaustivité est une valeur clé. Oublier "chapeau soleil" ou "après-ski" est un échec de l'app.
- **Next steps:**
  1. Constituer la liste complète (30-40 types) par recherche + validation utilisateur
  2. Catégoriser par tranche d'âge (0-1, 1-3, 3-6+)
  3. Définir quotas par défaut pour chaque type/âge
- **Resources needed:**
  - Recherche: Catalogues de vêtements enfants pour exhaustivité
  - Validation: Session avec Antoine pour confirmer la liste
  - Data: Table Types avec catégorie d'âge et quotas suggérés
- **Timeline:** Avant Sprint 1 (data prep), intégré Sprint 1

---

## Reflection & Follow-up

### What Worked Well
- **Five Whys**: A permis de creuser jusqu'au vrai besoin ("gap analysis" pas "inventaire")
- **Assumption Reversal**: A challengé l'hypothèse "interface = liste classique" → découverte clé "manquants > stock"
- **Role Playing**: A validé le workflow réel (app → vinted, pas l'inverse)
- **Morphological Analysis**: A structuré la complexité des catégories par âge
- **Exploration ouverte**: Antoine a apporté des insights critiques non anticipés (contexte 3 enfants, délai 3 semaines, anticipation 3 mois)

### Areas for Further Exploration
- **Design UI détaillé:** Wireframes de la vue "manquants" pour validation
- **Quotas par défaut:** Recherche sur les besoins standard par âge/type pour suggestions pertinentes
- **Format données Vinted:** Une fois reçues (RGPD), analyse du format pour préparer l'import
- **Stratégie PWA:** Offline-first? Service worker? Installation? À approfondir avec l'architecte
- **Stack frontend:** React vs Vue? Tailwind vs autre? Décision architecture

### Recommended Follow-up Techniques
- **Prototyping rapide:** Créer une maquette cliquable de la vue "manquants" pour validation UX
- **User Story Mapping:** Décomposer le workflow en stories détaillées pour le développement
- **Technical Spike:** POC de la partie ajout rapide pour valider la vélocité mobile

### Questions That Emerged
1. **Données initiales:** Comment bootstrapper l'inventaire avant l'import Vinted? Ajout manuel obligatoire?
2. **Quotas par défaut:** Quelle source fiable pour définir les besoins standard (4 pantalons? 6? 8?)?
3. **Hébergement gratuit:** Vercel + Supabase? Autre? Contraintes de la stack Java Spring?
4. **Authentification:** Nécessaire dès le MVP? Ou démo publique d'abord?
5. **Multi-device:** L'utilisateur ajoute sur mobile, mais consulte parfois sur desktop?

### Next Session Planning
- **Suggested topics:**
  1. Validation de la liste exhaustive des types d'habits (30-40 types)
  2. Définition des quotas par défaut (recherche + discussion)
  3. Priorisation des features post-MVP (import Vinted, alertes, etc.)
  
- **Recommended timeframe:** Dans les prochains jours (pour maintenir l'élan)

- **Preparation needed:**
  - Antoine: Réfléchir aux types d'habits spécifiques qu'il veut absolument voir
  - Mary: Recherche catalogues vêtements enfants pour liste exhaustive
  - Équipe: Réflexion sur l'architecture technique (Java Spring + PWA)

---

*Session facilitated using the BMAD-METHOD brainstorming framework*
