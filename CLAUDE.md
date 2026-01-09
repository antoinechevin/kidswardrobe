# CLAUDE.md

## Projet
KidsWardrobe - Application de gestion de garde-robe pour enfants.
Permet de suivre l'inventaire des vêtements et d'anticiper les besoins par saison.

## Stack technique
- **Back** : Spring Boot 3.2+ / Java 21 / Maven
- **BDD** : PostgreSQL + Flyway (migrations)
- **Front** : React + Vite + TypeScript
- **Tests** : JUnit 5 + AssertJ + Testcontainers + ArchUnit + Playwright-bdd
- **CI/CD** : GitHub Actions + Railway

## Architecture
Architecture hexagonale stricte.
```
backend/src/main/java/fr/music music/kidswardrobe/
├── domain/                    # Cœur métier, AUCUNE dépendance externe
│   ├── model/                 # Entités et Value Objects (POJOs purs)
│   ├── port/in/               # Interfaces des use cases
│   ├── port/out/              # Interfaces vers l'infrastructure
│   └── service/               # Implémentation des use cases
├── application/
│   └── dto/                   # Commandes et queries
└── infrastructure/
    ├── adapter/in/web/        # Controllers REST
    ├── adapter/out/persistence/  # JPA entities + repositories
    └── config/                # Configuration Spring
```

### Règles inviolables
1. Le package `domain` ne dépend de RIEN (pas de Spring, pas de JPA, pas de libs externes)
2. Les entités JPA (`*JpaEntity`) sont distinctes des entités domain
3. Les mappers font la conversion entre couches
4. Tout use case est défini par une interface dans `port/in/`
5. Toute dépendance externe est abstraite par une interface dans `port/out/`

## Conventions de code

### Java
- Records pour les Value Objects, DTOs, Commands
- Optional plutôt que null pour les retours
- Validation avec Bean Validation sur les DTOs d'entrée
- Nommage métier en français : `Enfant`, `Vetement`, `GardeRobe` (pas Child, Clothing)

### Nommage des classes
- `*UseCase` : interfaces port/in
- `*Repository` : interfaces port/out (domain)
- `*Service` : implémentation des use cases
- `*Controller` : adapters REST
- `*JpaEntity` : entités JPA
- `*JpaRepository` : interfaces Spring Data
- `*Adapter` : implémentation des ports out
- `*Response` / `*Command` : DTOs

### Tests
- `*Test` : tests unitaires (rapides, sans Spring)
- `*IT` : tests d'intégration (avec Spring + Testcontainers)
- `*ArchTest` : tests d'architecture ArchUnit

## Commandes
```bash
# Back
cd backend
./mvnw test                    # Tests unitaires
./mvnw verify                  # Tous les tests (intégration inclus)
./mvnw spring-boot:run         # Lancer en local

# Front  
cd frontend
npm install
npm run dev                    # Dev server
npm run build                  # Build prod

# E2E
cd e2e
npm install
npx playwright test            # Lancer les tests E2E

# Docker
docker-compose up -d           # Lance app + postgres
docker-compose down            # Stoppe tout
```

## Workflow ATDD

1. Je décris un besoin en langage naturel
2. Tu poses des questions de clarification jusqu'à couvrir tous les cas
3. Tu proposes un Gherkin dans `specs/wip/`
4. J'itère avec toi jusqu'à validation
5. Une fois validé : tu déplaces dans `specs/` et tu implémentes
6. La PR est verte quand tous les scénarios E2E passent

## Avant chaque commit
- [ ] Tous les tests passent (`./mvnw verify` + `npm test` dans e2e)
- [ ] Pas de warning de compilation
- [ ] Le code suit l'architecture hexagonale
- [ ] Les nouveaux use cases ont des tests

## Structure des branches
- `main` : production (déployé automatiquement)
- `feature/*` : nouvelles fonctionnalités (PR → preview Railway)