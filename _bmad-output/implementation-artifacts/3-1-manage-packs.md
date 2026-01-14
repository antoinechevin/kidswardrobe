# Story 3.1: Gestion des Packs Thématiques

Status: review

## Story
**As a** Parent,  
**I want** créer, activer et gérer des "Packs" de vêtements (ex: Été, Ski, Crèche),  
**So that** je puisse organiser mes besoins et ne voir que ce qui est pertinent pour la saison ou le contexte actuel.

---

## Acceptance Criteria

### 1. Modèle de Données Pack
- [x] Créer l'entité `Pack` avec les champs :
    - `id` (UUID, PK)
    - `name` (String, unique par utilisateur si multi-tenant, ici unique global)
    - `isActive` (Boolean, default true)
    - `isSystem` (Boolean, default false) - pour empêcher la suppression des packs par défaut.

### 2. Initialisation
- [x] Au démarrage de l'app (Seed/Initializer), un Pack "Essentiels" (ou "Quotidien") doit être créé.
    - `isSystem = true`
    - `isActive = true`

### 3. Backend API (CRUD)
- [x] `GET /api/packs` : Lister tous les packs.
- [x] `POST /api/packs` : Créer un pack (Nom obligatoire).
- [x] `PUT /api/packs/{id}` : Modifier un pack (Nom, Activation).
- [x] `DELETE /api/packs/{id}` : Supprimer un pack.
    - **Règle métier** : Impossible de supprimer un pack si `isSystem = true`.

### 4. Frontend (Settings Page)
- [x] Créer une page `/settings/packs`.
- [x] Afficher la liste des packs sous forme de cartes ou liste.
- [x] Toggle Switch pour Activer/Désactiver directement depuis la liste.
- [x] Bouton "Ajouter un Pack" -> Ouvre une modale ou un formulaire inline.
- [x] Indicateur visuel (cadenas ou autre) pour le pack "Essentiels" (non supprimable).

---

## Technical Requirements (Developer Guide)

### Architecture Compliance
- **Hexagonal Pattern** :
    - `Domain` : `Pack` (Record/Class sans annotations JPA).
    - `Application` : `PackService` (Interface Port In) + `PackRepositoryPort` (Interface Port Out).
    - `Infrastructure` : `PackController` (Web Adapter) + `PostgresPackRepository` (JPA Adapter).
- **Database** :
    - Table `packs` (id, name, is_active, is_system).
    - Flyway migration script (si applicable, sinon `ddl-auto` pour le prototype).
- **API Standards** :
    - Use `ResponseEntity`.
    - Handle exceptions (ex: `PackDeletionException` si système).

### Source Tree Locations
- **Backend** : `apps/api-backend/src/main/java/com/gaptextile/`
    - `domain/Pack.java`
    - `application/PackService.java`
    - `infrastructure/web/PackController.java`
    - `infrastructure/db/PackEntity.java`
- **Frontend** : `apps/web-pwa/app/settings/packs/page.tsx`

### Library & Framework Requirements
- **Backend** : Spring Boot 3, Java 21 LTS.
- **Frontend** : Next.js 14 (App Router), Tailwind CSS.
- **Components** : Réutiliser les composants UI existants (Boutons, Inputs).

---

## Testing Requirements

### Unit Tests (Backend)
- `PackServiceTest` :
    - Vérifier qu'on ne peut pas supprimer un pack système.
    - Vérifier la création et la récupération.

### Integration Tests (Backend)
- `PackControllerIntegrationTest` :
    - Tester les endpoints REST avec `MockMvc` ou `TestRestTemplate`.

### Manual UI Verification
- Aller sur `/settings/packs`.
- Créer "Pack Ski".
- Le désactiver.
- Essayer de supprimer "Essentiels" (doit être impossible ou bloqué).
- Supprimer "Pack Ski".

---

## Git Intelligence & Patterns
- **Pattern Controller** : Voir `InventoryController` pour exemple de gestion CORS et DTOs.
- **Pattern Entity** : Voir `ChildEntity` pour l'usage des UUID generated.
- **Pattern Frontend** : Voir `ClothingTypePage` pour la structure "Liste + Ajout".

## Dev Agent Record

### Completion Notes
- Implemented full Hexagonal Architecture stack for `Pack` management.
- Backend:
    - Domain: `Pack` record.
    - Application: `PackService` with business logic (system pack protection).
    - Infrastructure: `PostgresPackRepository`, `PackEntity`, `PackMapper`, `PackController`.
    - Initializer: `PackInitializer` creates "Essentiels" pack on startup.
- Frontend:
    - Created `/settings/packs` page with responsive list, toggle, create, and delete actions.
- Testing:
    - `PackTest`: Domain validation.
    - `PackServiceTest`: Business logic (delete system pack).
    - `PackControllerIntegrationTest`: REST API verification.
    - Manual UI verification checks out.

### File List
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/domain/Pack.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/domain/ports/output/PackRepositoryPort.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/application/PackService.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/infrastructure/db/PackEntity.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/infrastructure/db/PackMapper.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/infrastructure/db/JpaPackRepository.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/infrastructure/db/PostgresPackRepository.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/infrastructure/db/PackInitializer.java
#### [NEW] apps/api-backend/src/main/java/com/gaptextile/infrastructure/web/PackController.java
#### [NEW] apps/api-backend/src/test/java/com/gaptextile/domain/PackTest.java
#### [NEW] apps/api-backend/src/test/java/com/gaptextile/application/PackServiceTest.java
#### [NEW] apps/api-backend/src/test/java/com/gaptextile/infrastructure/web/PackControllerIntegrationTest.java
#### [NEW] apps/web-pwa/app/settings/packs/page.tsx

## Next Steps
1. Create Branch `feature/story-3-1-manage-packs`. (Done)
2. Implement Model & Repository. (Done)
3. Implement Service & Controller. (Done)
4. Implement Frontend Page. (Done)
5. Verify & PR. (Ready for Review)
