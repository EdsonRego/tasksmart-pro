#!/bin/bash

echo "🧭 Iniciando Fluxo 12: Configurações e Segredos (Config Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-config.yml \
  up --build
