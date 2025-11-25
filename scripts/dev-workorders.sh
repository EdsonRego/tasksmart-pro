#!/bin/bash

echo "🚀 Iniciando Fluxo 3: Ordens de Serviço (Work Orders Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-workorders.yml \
  up --build
