# PROGRESS.md

## Walking Skeleton

### Étape 1 : Structure + Back minimal ✅

- [x] .devcontainer/devcontainer.json
- [x] .devcontainer/post-create.sh
- [x] backend/pom.xml
- [x] Architecture hexagonale (packages domain/application/infrastructure)
- [x] HealthController + HealthService + CheckHealthUseCase
- [x] application.yml (dev + test profiles)
- [x] Dockerfile backend
- [x] docker-compose.yml (PostgreSQL 16)
- [x] Migration Flyway V1__init.sql
- [x] Tests unitaires (KidsWardrobeApplicationTest)
- [x] Tests intégration (HealthControllerIT avec Testcontainers)
- [x] Tests architecture ArchUnit (HexagonalArchitectureTest)
- [x] Validation : ./mvnw verify passe

### Étape 2 : CI GitHub Actions ✅

- [x] .github/workflows/ci.yml
- [x] Job test (backend avec PostgreSQL service)
- [x] Job build-docker
- [x] Cache Maven
- [x] Validation : CI verte

### Étape 3 : Frontend React minimal ✅

- [x] frontend/ setup Vite + React + TypeScript
- [x] App.tsx appelle /api/health et affiche la réponse
- [x] Configuration Vite avec proxy vers backend (:8080)
- [x] Configuration ESLint + TypeScript strict
- [x] Dockerfile frontend
- [x] Mise à jour docker-compose.yml (backend + frontend + postgres)
- [x] Validation : docker-compose up affiche "Status: UP"

### Étape 4 : Tests E2E playwright-bdd ✅

- [x] e2e/ setup avec Playwright + playwright-bdd
- [x] features/health.feature (Gherkin)
- [x] steps/health.steps.ts (implémentation)
- [x] steps/fixtures.ts
- [x] playwright.config.js
- [x] Validation : npm test passe localement (avec docker-compose up -d)

### Étape 5 : E2E dans la CI ✅

- [x] Job e2e dans ci.yml
- [x] Validation : CI complète verte avec E2E

### Étape 6 : Configuration finale

- [ ] .env.example
- [x] specs/ et specs/wip/
- [x] .claude/ (context files)
- [x] README.md complet
- [x] CLAUDE.md (instructions et conventions)
- [x] WALKING_SKELETON.md (documentation technique)
