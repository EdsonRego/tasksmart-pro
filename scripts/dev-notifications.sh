#!/bin/bash

echo "🔔 Iniciando Fluxo 6: Notificações (Notifications Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-notifications.yml \
  up --build
