#!/bin/bash

echo "🔗 Iniciando Fluxo 8: Integrações Externas (Integrations Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-integrations.yml \
  up --build
