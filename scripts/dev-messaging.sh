#!/bin/bash

echo "📡 Iniciando Fluxo 11: Mensageria e Eventos (Messaging Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-messaging.yml \
  up --build
