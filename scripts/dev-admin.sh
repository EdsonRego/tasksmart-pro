#!/bin/bash

echo "🛡️ Iniciando Fluxo 9: Administrativo (Admin Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-admin.yml \
  up --build
