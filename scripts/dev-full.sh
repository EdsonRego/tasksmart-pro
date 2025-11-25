#!/bin/bash

echo "🌐 Iniciando Fluxo 13: Full DEV (todos os microserviços)..."
echo "⚠️ AVISO: Este fluxo é muito pesado e pode travar seu notebook."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-full.yml \
  up --build
