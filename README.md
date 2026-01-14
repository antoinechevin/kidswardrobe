# Kids Wardrobe - Gap Analysis App

## Démarrage Rapide en Local

Pour lancer l'application complète sur votre machine, suivez ces 3 étapes dans des terminaux séparés :

### 1. Base de données (Docker)
Démarrez PostgreSQL via Docker Compose :
```bash
docker-compose -f docker/docker-compose.yml up -d
```
*Vérification :* Le conteneur `kidswardrobe-db` doit être "Up".

### 2. Backend (Spring Boot)
Lancez le serveur API (Java 21) :
```bash
./gradlew :apps:api-backend:bootRun
```
*URL API :* http://localhost:8080/api/health

### 3. Frontend (Next.js)
Lancez l'interface web :
```bash
cd apps/web-pwa
npm run dev
```
*URL Web :* http://localhost:3000

---

## Pré-requis
*   Docker & Docker Compose
*   Java 21 (ou utiliser `./gradlew` qui gère le téléchargement)
*   Node.js 20+