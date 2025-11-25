#!/bin/bash

echo "🚀 Iniciando Fluxo 1: Autenticação e Identidade (Auth Flow)..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-auth.yml \
  up --build
