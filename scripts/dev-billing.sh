#!/bin/bash

echo "💳 Iniciando Fluxo 7: Billing e Pagamentos..."

docker compose \
  -f docker/docker-compose.dev.yml \
  -f docker/docker-compose.dev-billing.yml \
  up --build
