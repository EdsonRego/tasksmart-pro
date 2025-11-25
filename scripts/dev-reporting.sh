#!/bin/bash

echo "📊 Iniciando Fluxo 10: Relatórios (Reporting Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-reporting.yml \
  up --build
