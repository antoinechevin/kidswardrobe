# RFC : Stratégie de Déploiement de "Preview Environments" (CI/CD)

**Auteur** : Winston (Architecte)
**Date** : 13/01/2026
**Statut** : Proposition

## 1. Contexte et Besoin

L'objectif est d'avoir, pour chaque **Pull Request (PR)**, un environnement éphémère complet déployé automatiquement. Cela vous permet de tester fonctionnellement la feature (Front + Back + DB) "en conditions réelles" avant de valider le merge dans `main`.

## 2. Le Challenge Technique

Notre stack est "Composite" :
*   **Frontend** (Next.js) : Facile à prévisualiser (Serverless / Static).
*   **Backend** (Spring Boot) : Nécessite un serveur d'application (Stateful).
*   **Database** (PostgreSQL) : Le point dur. Chaque PR a besoin d'une base de données isolée pour ne pas casser les données de prod ou d'autres PRs.

## 3. Options Stratégiques

### Option A : La "Rolls Royce" Serverless (Recommandée pour l'Agilité)
Utilisation de services modernes (PaaS) qui gèrent nativement les environnements de preview.

*   **Frontend** : **Vercel**. Déploie automatiquement chaque branche/PR avec une URL unique (`mon-projet-git-branch-app.vercel.app`).
*   **Database** : **Neon.tech** (PostgreSQL Serverless). Fonctionnalité "Branching" : Créer une branche Git crée instantanément une branche DB (copie des données + schéma) en quelques secondes.
*   **Backend** : **Railway** ou **Render**. Connecté au dépôt GitHub. Peut être configuré pour créer un "Service éphémère" pour chaque PR (PR Environments).

**Flux CI/CD :**
1.  Push sur `feature/xyz`.
2.  CI créé branche Neon `feature/xyz` (Database URL unique).
3.  Railway déploie Backend avec env var `DB_URL` de Neon.
4.  Vercel déploie Frontend avec env var `API_URL` de Railway.
5.  Bot commente la PR avec les liens.

*   ✅ **Pros** : Isolation totale, Données réelles, Zéro infra à gérer.
*   ❌ **Cons** : Coût potentiel (bien que les tiers gratuits suffisent souvent au début), dépendance PaaS.

### Option B : Le "Staging Unique" (Low Tech / Low Cost)
On ne déploie pas *chaque* PR simultanément, mais on déploie la PR *active* sur un serveur de staging unique.

*   **Infrastructure** : Un VPS (ex: Hetzner, OVH) ou un PaaS gratuit (Fly.io).
*   **Flux** : Quand vous pushez sur une PR, la GitHub Action déploie cette version sur l'environnement de Staging (écrase la version précédente).
*   ✅ **Pros** : Simple, gratuit (si auto-hébergé ou tiers gratuit).
*   ❌ **Cons** : Pas de tests parallèles (si deux PRs sont ouvertes, la dernière écrase l'autre sur le staging).

## 4. Recommandation de l'Architecte

Pour un projet solo/petite équipe comme *Kids Wardrobe*, je recommande une approche hybride pragmatique : **Option A "Allégée"**.

1.  **Frontend** : Utiliser **Vercel** (Gratuit). C'est le standard pour Next.js. Vous aurez des previews automatiques du Front pour chaque PR.
2.  **Backend/DB** :
    *   *Dans un premier temps* : Utiliser une **Base de développement partagée** (cloud) ou une base H2 en mémoire pour les previews (si pas de persistance requise entre les tests).
    *   *Alternative Base* : Utiliser **Neon** (Gratuit) pour avoir la base cloud facile.
    *   *Deployment* : Le déploiement automatique du Backend Spring Boot à chaque PR est lourd (temps de démarrage, mémoire).

**Mon plan proposé :**
1.  Configurer **Vercel** pour le Frontend (Previews automatiques immédiates).
2.  Configurer **Neon** pour la Base de données (Postgres Cloud).
3.  Configurer **Railway** (ou équivalent) pour le Backend, lié à la branche `main` (Staging/Prod) et activer les "PR Deploys" uniquement si nécessaire car cela consomme des crédits.

### Est-ce que cela correspond à vos attentes ?
Si oui, la prochaine étape (Story) consisterait à configurer ces comptes et les secrets dans GitHub.
