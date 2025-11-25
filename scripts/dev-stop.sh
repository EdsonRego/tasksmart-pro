#!/bin/bash
echo "🛑 Parando todos os containers DEV..."
docker compose -f docker/docker-compose.dev.yml down
