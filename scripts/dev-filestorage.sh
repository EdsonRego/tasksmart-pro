#!/bin/bash

echo "🗂️ Iniciando Fluxo 5: File Storage Flow..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-filestorage.yml \
  up --build
