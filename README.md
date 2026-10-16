
# Projet : Application Bancaire avec Microservices et Agent IA

## 1. Objectif du projet

L'objectif de ce projet est de développer une application bancaire basée sur une architecture microservices avec Spring Boot et Spring Cloud, puis d'intégrer un agent d'intelligence artificielle permettant d'interagir avec les fonctionnalités des microservices.

Le projet est organisé en deux parties : la mise en place de l'architecture backend distribuée et le développement d'un agent IA connecté aux services bancaires via le protocole MCP (*Model Context Protocol*).

## 2. Technologies utilisées

- **Java** : langage de programmation.
- **Spring Boot** : développement des microservices.
- **Spring Cloud Gateway** : routage des requêtes.
- **Netflix Eureka** : découverte des services.
- **Spring Cloud OpenFeign** : communication interservices.
- **Resilience4J** : tolérance aux pannes avec Circuit Breaker.
- **Swagger / OpenAPI** : documentation et test des API REST.
- **Postman** : test des services backend.
- **Spring AI** : intégration de l'intelligence artificielle.
- **MCP (Model Context Protocol)** : exposition et utilisation des fonctionnalités des microservices par un agent IA.
- **Telegram et Discord** : interfaces conversationnelles pour le chatbot.

## 3. Partie 1 : Architecture Microservices

### 3.1. Développement du Customer-Service

Création du microservice chargé de gérer les clients de l'application bancaire. Il expose les fonctionnalités nécessaires à la consultation et à la gestion des informations des clients.

### 3.2. Développement de l'EBank-Service

Création du microservice dédié aux opérations bancaires. Il permet de gérer les fonctionnalités liées aux comptes bancaires et aux données associées.

### 3.3. Communication interservices avec OpenFeign

Mise en place de la communication entre Customer-Service et EBank-Service à l'aide de Spring Cloud OpenFeign.

Cette approche simplifie les appels HTTP entre les microservices et facilite l'intégration de leurs fonctionnalités respectives.

### 3.4. Tolérance aux pannes avec Resilience4J

Intégration du mécanisme Circuit Breaker avec Resilience4J afin de gérer les défaillances lors des communications entre services.

Ce mécanisme permet notamment de limiter les appels vers un service temporairement indisponible et de prévoir un comportement de repli lorsque cela est configuré.

### 3.5. Développement de la Gateway

Mise en place de Spring Cloud Gateway comme point d'entrée de l'application.

La Gateway permet de router les requêtes vers les microservices appropriés et de centraliser l'accès à leurs API.

### 3.6. Développement du Discovery Service

Création d'un service de découverte basé sur Eureka.

Il permet aux microservices de s'enregistrer et de découvrir les autres services disponibles, facilitant ainsi la communication dans une architecture distribuée.

### 3.7. Tests des services backend

Utilisation de Postman et de Swagger UI pour tester les API REST des microservices.

Ces outils permettent de vérifier les endpoints, les paramètres des requêtes, les données retournées et le comportement des services.

## 4. Partie 2 : Agent IA et protocole MCP

### 4.1. Développement d'un agent IA avec Spring AI

Création d'un agent d'intelligence artificielle basé sur Spring AI afin de permettre aux utilisateurs d'interagir avec les fonctionnalités de l'application bancaire en langage naturel.

### 4.2. Exposition des fonctionnalités via MCP

Mise en place du protocole MCP (*Model Context Protocol*) pour exposer les fonctionnalités des microservices sous forme d'outils utilisables par l'agent IA.

Cette approche permet à l'agent d'accéder aux opérations autorisées des services bancaires à travers une interface standardisée.

### 4.3. Tests avec un client MCP

Utilisation d'un client MCP pour vérifier la connexion au serveur MCP et tester les outils exposés par les microservices.

### 4.4. Connexion du chatbot aux microservices avec MCP

Intégration du client MCP dans le chatbot afin de permettre à l'agent IA de sélectionner et d'appeler les outils appropriés selon les demandes de l'utilisateur.

Cette intégration relie les interactions en langage naturel aux fonctionnalités backend de l'application.

### 4.5. Tests du chatbot avec un client REST

Exposition d'un endpoint REST permettant d'envoyer des messages au chatbot et de récupérer ses réponses.

Les tests permettent de vérifier les échanges entre le client, l'agent IA et les outils MCP.

### 4.6. Intégration avec Telegram

Connexion du chatbot à Telegram afin de permettre aux utilisateurs d'interagir avec l'agent IA à travers une interface de messagerie.

### 4.7. Intégration avec Discord

Connexion du chatbot à Discord pour rendre les fonctionnalités de l'agent IA accessibles depuis un serveur ou une interface conversationnelle Discord.

## 5. Architecture générale

L'application repose sur les composants suivants :

- **Customer-Service** : gestion des clients.
- **EBank-Service** : gestion des fonctionnalités bancaires.
- **Gateway-Service** : point d'entrée et routage des requêtes.
- **Discovery-Service** : enregistrement et découverte des microservices.
- **Agent IA** : traitement des demandes en langage naturel avec Spring AI.
- **Serveur MCP** : exposition des outils accessibles à l'agent.
- **Clients conversationnels** : accès au chatbot via REST, Telegram et Discord.

### Flux de communication

1. Le client envoie une requête à la Gateway ou au chatbot.
2. La Gateway route les requêtes vers les services backend appropriés.
3. Les microservices communiquent entre eux grâce à OpenFeign.
4. Resilience4J contribue à gérer les défaillances des appels protégés par le Circuit Breaker.
5. L'agent IA utilise les outils MCP disponibles pour accéder aux fonctionnalités autorisées.
6. Le chatbot retourne une réponse au client REST, Telegram ou Discord.

## 6. Résultats attendus

À l'issue du projet, l'application doit permettre de :

- Organiser les fonctionnalités bancaires dans des microservices indépendants.
- Assurer la communication interservices avec OpenFeign.
- Améliorer la résilience des communications avec Resilience4J.
- Centraliser le routage avec Spring Cloud Gateway.
- Découvrir les services grâce à Eureka.
- Tester et documenter les API backend avec Postman et Swagger UI.
- Développer un agent IA avec Spring AI.
- Exposer et exploiter des outils via MCP.
- Interagir avec le chatbot à travers un client REST, Telegram et Discord.

## 7. Conclusion

Ce projet permet de combiner une architecture microservices avec les capacités de l'intelligence artificielle générative.

La première partie met en pratique les concepts de communication interservices, de routage, de découverte et de tolérance aux pannes. La deuxième partie étend cette architecture en intégrant un agent IA capable d'utiliser les fonctionnalités backend via MCP et de les rendre accessibles à travers plusieurs interfaces conversationnelles.

L'ensemble constitue une base pour la conception d'applications distribuées intégrant des services backend et des interfaces conversationnelles intelligentes.

## 8. Ressources pédagogiques

- [Partie 1 : Architecture Microservices et communication interservices](https://www.youtube.com/watch?v=cdFz3VemT1Q)
- [Partie 2 : Agent IA avec Spring AI et MCP](https://www.youtube.com/watch?v=JHvxSZTWSsY)
