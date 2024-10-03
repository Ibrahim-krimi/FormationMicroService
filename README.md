# Microservices Example with Docker and Kubernetes

## Description

Ce projet est un exemple de microservices développé en utilisant **Spring Boot**, déployé avec **Docker** et orchestré par **Kubernetes**. Le projet comprend deux services :

1. **Produit Service**: Un service RESTful qui gère des produits.
2. **Commande Service**: Un service RESTful qui gère des commandes, dépendant du Produit Service pour obtenir des informations sur les produits.

Les images Docker des services peuvent être trouvées sur Docker Hub :
- [Commande Service Image](https://hub.docker.com/repository/docker/ibrahimkr/commande/general)
- [Produit Service Image](https://hub.docker.com/repository/docker/ibrahimkr/produit/general)

## Prérequis

- Docker installé et configuré.
- Kubernetes (minikube, k8s cluster, etc.) configuré pour exécuter des commandes `kubectl`.
- Les images Docker doivent être disponibles dans votre registre Docker local ou accessibles depuis Docker Hub.

## Étapes de Déploiement

### 1. Déployer sur Kubernetes

Pour construire les images Docker, utilisez les commandes suivantes (exécutez-les dans les répertoires respectifs de chaque service) :

```bash
docker build -t ibrahimkr/produit:v1.0 ./ProduitService
docker build -t ibrahimkr/commande:v1.0 ./CommandeService
```

### 2. Construire les Images Docker

Les fichiers de configuration Kubernetes (produit-service-deployment.yml et commande-service-deployment.yml) définissent les déploiements et services nécessaires.

```bash
kubectl apply -f produit-service-deployment.yml
kubectl apply -f commande-service-deployment.yml
```
