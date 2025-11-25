#!/bin/bash

echo "🚀 Iniciando Fluxo 2: Gestão de Usuários (User Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-user.yml \
  up --build
