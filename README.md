# 👕 KidsWardrobe

> Application de gestion de garde-robe pour enfants

## Stack technique

- **Backend**: Spring Boot 3.2+ / Java 21 / Maven
- **Base de données**: PostgreSQL + Flyway
- **Frontend**: React + Vite + TypeScript
- **Tests**: JUnit 5 + AssertJ + Testcontainers + ArchUnit + Playwright-bdd
- **CI/CD**: GitHub Actions + Railway

## Architecture

Architecture hexagonale stricte. Voir [CLAUDE.md](./CLAUDE.md) pour les détails.

## Démarrage rapide

### Prérequis

- Java 21
- Node.js 20
- Docker & Docker Compose

### Développement local

1. **Démarrer PostgreSQL**
```bash
docker-compose up -d
```

2. **Lancer le backend**
```bash
cd backend
./mvnw spring-boot:run
```
L'API sera disponible sur http://localhost:8080

3. **Lancer le frontend**
```bash
cd frontend
npm install
npm run dev
```
L'application sera disponible sur http://localhost:5173

### Tests

**Backend**
```bash
cd backend
./mvnw test                    # Tests unitaires
./mvnw verify                  # Tests unitaires + intégration
```

**Frontend**
```bash
cd frontend
npm run lint                   # Lint
npm run build                  # Build
```

**E2E**
```bash
cd e2e
npm install
npx playwright test            # Tests E2E
npx playwright test --ui       # Mode UI
```

## Structure du projet

```
kidswardrobe/
├── backend/                   # API Spring Boot
│   └── src/
│       └── main/java/fr/musicmusic/kidswardrobe/
│           ├── domain/        # Cœur métier (AUCUNE dépendance externe)
│           ├── application/   # DTOs et orchestration
│           └── infrastructure/# Adapters (web, persistence, config)
├── frontend/                  # Application React
├── e2e/                      # Tests end-to-end Playwright
└── specs/                    # Spécifications Gherkin (WIP + validées)
```

## Workflow ATDD

1. Écrire la spécification en Gherkin dans `specs/wip/`
2. Valider avec l'équipe
3. Déplacer dans `specs/` une fois validé
4. Implémenter la fonctionnalité
5. Les tests E2E doivent passer ✅

## Développement

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/antoinechevin/kidswardrobe)

## CI/CD

- **Push sur `main`**: Déploiement automatique
- **Pull Request**: Tests + Preview sur Railway

---

*Développé en vibe coding avec Claude Code + Happy Coder 🤖📱*