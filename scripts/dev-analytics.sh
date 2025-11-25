#!/bin/bash

echo "📈 Iniciando Fluxo 4: Analytics (KPIs e Métricas)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-analytics.yml \
  up --build
