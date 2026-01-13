# Architecture Technique : Gap Analysis Textile Enfant

**Version :** 1.0  
**Statut :** Validé  
**Architecte :** Winston 🏗️  
**Projet :** Inventaire Textile & Gap Analysis
**Stack :** Java 21, Spring Boot 3, PostgreSQL (JSONB)

## 1. Résumé Technique
L'architecture repose sur le pattern **Hexagonal (Clean Architecture)** afin d'isoler le "Moteur de Gap Analysis" (le cœur métier) de l'interface utilisateur et de la persistance. Le projet est structuré en **Monorepo** pour faciliter la cohérence entre le backend Spring Boot et le frontend PWA.

### Principes Clés
* **Isolation Métier** : Le calcul des manques ne dépend d'aucune bibliothèque externe.
* **Flexibilité de Schéma** : Usage intensif du format JSONB pour supporter les types de vêtements personnalisés et leurs attributs (TOG, dimensions).
* **API First** : Contrat d'interface défini via OpenAPI pour une intégration fluide avec le frontend.

---

## 2. Diagramme de Haut Niveau

```mermaid
graph LR
    subgraph "Frontend (PWA)"
        UI[React/Next.js]
    end

    subgraph "Backend (Architecture Hexagonale)"
        subgraph "Infrastructure"
            WA[Web Adapter / REST]
            PA[Persistence Adapter / JPA]
        end
        
        subgraph "Application"
            UC[Use Cases / Services]
        end
        
        subgraph "Domain"
            Core[Gap Analysis Engine]
        end
    end

    UI <--> WA
    WA --> UC
    UC --> Core
    UC --> PA
    PA <--> DB[(PostgreSQL)]
	
## 3. Tech Stack Definitive

| Catégorie | Technologie | Version | Rationale |
| :--- | :--- | :--- | :--- |
| **Langage** | Java | 21 (LTS) | Utilisation des Records, Sealed Classes et Virtual Threads pour un code concis et performant. |
| **Framework** | Spring Boot | 3.2.x | Standard industriel pour les API robustes, support natif de la conteneurisation et intégration JPA. |
| **Base de données** | PostgreSQL | 16 | Support natif JSONB indispensable pour la flexibilité des catégories personnalisées. |
| **Build Tool** | Gradle | 8.x | Gestion multi-projets (Monorepo) optimisée. |
| **API** | REST / OpenAPI | 3.0 | Documentation interactive automatique via Swagger/SpringDoc. |
| **Frontend** | React / Next.js | Latest | SEO, performance PWA (Service Workers) et bibliothèques de composants modernes (Tailwind). |

---

## 4. Modèle de Données (PostgreSQL)

Le schéma combine des tables relationnelles strictes pour l'intégrité et du JSONB pour la flexibilité métier.

### Entités Clés
* **Child (Enfant)** : `id (UUID)`, `name (String)`, `current_size_id (String)`.
* **ClothingType (Type de vêtement)** : `id (UUID)`, `name (String)`, `default_season (Enum: FROID, CHAUD, PERM)`, `attributes (JSONB)`.
  * *Note : Le JSONB stocke les métadonnées spécifiques (ex: TOG pour les gigoteuses).*
* **InventoryItem (Article en stock)** : `id (UUID)`, `child_id (FK)`, `type_id (FK)`, `size_id (String)`, `quantity (Int)`, `season (Enum)`.
* **Pack (Pack Thématique)** : `id (UUID)`, `name (String)`, `is_active (Boolean)`.
* **Quota (Objectif)** : `id (UUID)`, `child_id (FK)`, `type_id (FK)`, `pack_id (FK, nullable)`, `target_quantity (Int)`.
  * *Note : Si `pack_id` est nul, il s'agit d'un quota "Quotidien".*

---

## 5. Spécifications du Moteur de Gap Analysis

Le cœur algorithmique réside dans le calcul consolidé des manques. 

**Logique de calcul :**
1. **Extraction des besoins** : Somme des quotas (`target_quantity`) pour un enfant donné, en filtrant les quotas rattachés à des `Packs` désactivés.
2. **Extraction du stock** : Somme des `quantity` par `type_id` pour la taille actuelle de l'enfant.
3. **Calcul du Différentiel** : `Gap = Stock - Besoins`.
4. **Classification d'Urgence** :
   - `Gap < 0` : Statut **CRITICAL** (Rouge).
   - `Gap == 0` : Statut **OK** (Vert).
   - `Gap > 0` : Statut **SURPLUS** (Bleu/Gris).

---

## 6. Structure du Projet (Source Tree)

```text
project-root/
├── apps/
│   ├── api-backend/           # Module Spring Boot (Java 21)
│   │   ├── src/main/java/com/gaptextile/
│   │   │   ├── domain/        # Logique Pure (Sans frameworks)
│   │   │   ├── application/   # Services de Use Case (Ports)
│   │   │   └── infrastructure/# Adapters (Web Controllers, JPA Repositories)
│   └── web-pwa/               # Module Frontend (React/Next.js)
├── libs/
│   └── shared-dtos/           # Objets JSON partagés (TypeScript & Java)
├── docker/                    # Dockerfiles de l'environnement
└── settings.gradle            # Configuration du Monorepo

## 7. Standards de Développement (IA Readiness)

Pour garantir que les agents IA de développement (Dev Agents) produisent un code cohérent et respectent les choix structurants, les règles suivantes sont impératives :

1. **Architecture Hexagonale Stricte** :
   - Le package `domain` ne doit contenir aucune annotation Spring (ex: `@Service`, `@Component`) ou JPA (ex: `@Entity`).
   - Utilisez des interfaces (Ports) dans le package `application` pour définir les interactions avec le monde extérieur.
2. **Usage des Records Java** :
   - Tous les DTOs (Data Transfer Objects) et les objets de valeur (Value Objects) doivent être implémentés sous forme de `record` pour garantir l'immuabilité.
3. **Persistance JSONB** :
   - Ne créez pas de tables de jointure complexes pour les attributs de vêtements. Utilisez la colonne `attributes` (JSONB) de la table `ClothingType`.
   - L'IA doit mapper ces champs dynamiques vers une `Map<String, Object>` dans les entités de l'adaptateur de persistance.
4. **API de Saisie en Lot (Batch)** :
   - L'endpoint de création d'articles doit obligatoirement accepter une liste d'objets : `POST /api/inventory/batch`.
   - La validation doit être effectuée sur l'ensemble du lot avant toute insertion.
5. **Gestion des Tailles** :
   - Les identifiants de taille (ex: "24M", "3T") doivent être validés par rapport à un énuméré ou un référentiel statique défini dans le cœur du domaine.

---

## 8. Rapport de Validation (Winston - Architecte)

Avant de passer à la phase de développement, j'ai validé la robustesse de cette architecture :

| Critère | Statut | Commentaire de l'Architecte |
| :--- | :--- | :--- |
| **Maintenabilité** | ✅ HAUTE | L'isolation du moteur de calcul facilite les tests et les évolutions futures sans effets de bord. |
| **Performance** | ✅ OPTIMISÉE | L'indexation GIN sur PostgreSQL assurera des performances constantes malgré la flexibilité du JSONB. |
| **Flexibilité** | ✅ VALIDÉE | Le système de "Packs" et de catégories dynamiques répond exactement au besoin de personnalisation parentale. |
| **Prêt pour le Dev** | 🚀 GO | Le socle technique est cohérent et les limites de responsabilité entre front et back sont claires. |

**Décision finale :** L'architecture est validée. Nous sommes prêts pour l'implémentation de l'Epic 1.