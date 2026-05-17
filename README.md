# Room Rental System

## Présentation
Room Rental System est une application web de gestion de locations de chambres destinée aux étudiants et aux propriétaires. Elle propose une API backend en Spring Boot et un frontend en React + Vite.

Fonctionnalités principales :
- Authentification JWT et gestion des rôles
- Inscription et connexion d'étudiants et de propriétaires
- Création, modification et suppression de chambres
- Consultation des annonces de location
- Envoi et gestion de demandes de location
- Notifications et messagerie

## Architecture
- `backend/` : API REST Spring Boot
- `frontend/` : interface utilisateur React + Vite
- `BD/rooms_db.sql` : script SQL d’exemple pour la base de données MySQL

## Prérequis
- Java 17
- Maven
- Node.js 18+ et npm
- MySQL

## Installation locale

### 1. Base de données
1. Créez une base MySQL nommée `rooms_db`
2. Importez `BD/rooms_db.sql` si nécessaire

Par défaut, le backend utilise :
- URL : `jdbc:mysql://localhost:3306/rooms_db`
- Utilisateur : `root`
- Mot de passe : (vide)

> Si vous changez ces paramètres, mettez à jour `backend/src/main/resources/application.properties`.

### 2. Démarrer le backend
Ouvrez un terminal dans `backend/` :

```powershell
cd backend
./mvnw spring-boot:run
```

Le backend fonctionne sur `http://localhost:8080`.

### 3. Démarrer le frontend
Ouvrez un autre terminal dans `frontend/` :

```powershell
cd frontend
npm install
npm run dev
```

Le frontend démarre généralement sur `http://localhost:5173`.

## Backend
- `src/main/java/com/kotbihousing/backend/controller` : contrôleurs REST
- `src/main/java/com/kotbihousing/backend/service` : logique métier
- `src/main/java/com/kotbihousing/backend/repository` : accès aux données JPA
- `src/main/java/com/kotbihousing/backend/model` : entités
- `src/main/java/com/kotbihousing/backend/dto` : objets de transfert de données
- `src/main/java/com/kotbihousing/backend/config` : configuration de sécurité
- `src/main/resources/application.properties` : configuration de l’application

## Frontend
- `src/pages` : pages de l’application
- `src/components` : composants réutilisables
- `src/services` : appels API Axios
- `src/context` : gestion du contexte d’authentification
- `src/constants` : données statiques et constantes

## Scripts utiles
### Frontend
- `npm run dev` : lance le serveur de développement
- `npm run build` : génère la version de production
- `npm run lint` : vérifie le code avec ESLint

### Backend
- `./mvnw spring-boot:run` : lance le backend
- `./mvnw test` : exécute les tests

## Configuration importante
Dans `backend/src/main/resources/application.properties` :
- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`
- `jwt.secret`
- `jwt.expiration`
- `server.port`

## Déploiement
1. Construisez le backend avec Maven.
2. Générez le frontend avec `npm run build`.
3. Déployez les fichiers statiques sur un serveur web ou intégrez-les au backend.
4. Configurez MySQL et les variables d’environnement.

## Améliorations possibles
- Recherche et filtrage des chambres
- Gestion avancée des réservations et du calendrier
- Paiements en ligne
- Système d’avis et de notation
- Authentification multi-facteur

