README parcial para explicar o uso do Fluxo 1

📌 Adicione isto no README principal do projeto:

🔐 Fluxo 1 – Autenticação e Identidade (Auth Flow)

Este fluxo sobe somente os microserviços necessários para:

login

refresh token

cadastro de usuário

autenticação JWT

autorização por roles

recuperação de senha

Serviços envolvidos:
Serviço	Porta	Função
gateway-service	8080	Porta de entrada
auth-service	8081	Autenticação
user-service	8082	Usuários
notification-service	8086	E-mails automáticos
postgres	5432	Banco principal
redis	6379	Cache/Tokens
Como subir o fluxo
./scripts/dev-auth.sh

Como parar
./scripts/dev-stop.sh

### 🔹 Fluxo 2 – Gestão de Usuários (User Flow)

Este fluxo sobe apenas os serviços necessários para:

- CRUD de usuários
- gestão de perfis/roles
- atualização de dados de conta
- envio de e-mails relacionados à conta (se configurado)

**Serviços incluídos:**

| Serviço             | Porta | Descrição                        |
|---------------------|-------|----------------------------------|
| gateway-service     | 8080  | API Gateway / BFF                |
| auth-service        | 8081  | Autenticação/JWT                 |
| user-service        | 8082  | Gestão de usuários               |
| notification-service| 8086  | Envio de notificações/e-mails    |
| postgres            | 5432  | Banco de dados principal (DEV)   |
| redis               | 6379  | Cache / suporte a tokens (DEV)   |

**Como subir:**

./scripts/dev-user.sh
Como parar:

bash
Copiar código
./scripts/dev-stop.sh 

### 🔧 Fluxo 3 – Ordens de Serviço (Work Orders)

Este fluxo sobe somente os serviços necessários para:

- criação de ordens de serviço  
- anexos e documentos  
- atualização de status  
- notificações automáticas  
- consulta de usuários  
- autenticação e autorização via JWT  

**Serviços incluídos:**

| Serviço               | Porta | Função                                   |
|-----------------------|-------|-------------------------------------------|
| gateway-service       | 8080  | Entrada do sistema                        |
| auth-service          | 8081  | Autenticação                              |
| user-service          | 8082  | Informações de usuários                   |
| work-order-service    | 8083  | Núcleo do fluxo de ordens de serviço      |
| file-storage-service  | 8084  | Armazenar anexos e documentos             |
| notification-service  | 8086  | Notificações / e-mails                    |
| postgres              | 5432  | Banco principal                           |
| mongo                 | 27017 | Armazenamento de anexos e documentos      |
| redis                 | 6379  | Cache (opcional)                          |

**Como subir:**

./scripts/dev-workorders.sh
Como parar:

Copiar código
./scripts/dev-stop.sh 

### 📊 Fluxo 4 – Analytics (Dashboards e KPIs)

Este fluxo sobe apenas os serviços necessários para:

- cálculos de performance
- KPIs de ordens de serviço
- dashboards operacionais
- visão por técnico, cliente, status
- agregações e estatísticas

**Serviços incluídos:**

| Serviço             | Porta | Função |
|---------------------|-------|--------|
| analytics-service   | 8085  | KPIs, métricas, dashboards |
| work-order-service  | 8083  | Fonte de dados principal |
| user-service        | 8082  | Referência de usuários |
| auth-service        | 8081  | Autenticação |
| gateway-service     | 8080  | Entrada do sistema |
| postgres            | 5432  | Banco principal |
| redis               | 6379  | Cache (opcional) |

**Subir:**

./scripts/dev-analytics.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 🗂️ Fluxo 5 – File Storage (Armazenamento de Arquivos)

Este fluxo sobe apenas os serviços necessários para:

- upload e download de arquivos  
- anexos das ordens de serviço  
- gerenciamento de documentos  
- integração com usuários e OS  
- armazenamento em MongoDB (DEV)  
- futura integração com S3 (PROD)

**Serviços incluídos:**

| Serviço               | Porta | Função                                 |
|-----------------------|-------|-----------------------------------------|
| file-storage-service  | 8084  | Armazenamento de arquivos               |
| work-order-service    | 8083  | Consistência de anexos por OS           |
| user-service          | 8082  | Dados de usuários                       |
| auth-service          | 8081  | Autenticação                            |
| gateway-service       | 8080  | Entrada do sistema                      |
| mongo                 | 27017 | Banco NoSQL para documentos             |
| postgres              | 5432  | Banco relacional (usuários/OS)          |
| redis                 | 6379  | Cache opcional                          |

**Subir:**

./scripts/dev-filestorage.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 🔔 Fluxo 6 – Notificações (Notifications Flow)

Este fluxo sobe apenas os serviços mínimos necessários para:

- envio de e-mails 
- notificações automáticas relacionadas a usuários e ordens de serviço
- integração básica com SMTP
- integração com usuários e ordens de serviço

**Serviços incluídos:**

| Serviço               | Porta | Função                                |
|-----------------------|-------|----------------------------------------|
| notification-service  | 8086  | Envio de notificações e e-mails        |
| user-service          | 8082  | Dados dos destinatários                |
| work-order-service    | 8083  | Origem dos eventos de OS               |
| auth-service          | 8081  | Autenticação                           |
| gateway-service       | 8080  | BFF / roteamento                       |
| postgres              | 5432  | Suporte aos serviços                   |
| redis                 | 6379  | Cache (opcional)                       |

**Subir:**

./scripts/dev-notifications.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 💳 Fluxo 7 – Billing e Pagamentos (Billing Flow)

Este fluxo sobe apenas os serviços necessários para:

- cálculos de cobranças  
- geração de faturas  
- consolidação de custos  
- integrações futuras com gateways de pagamento  
- relacionamento entre usuários, OS e valores  

**Serviços incluídos:**

| Serviço               | Porta | Função                                     |
|-----------------------|-------|---------------------------------------------|
| billing-service       | 8087  | Núcleo de cobranças e pagamentos            |
| work-order-service    | 8083  | Origem dos dados de cobrança                |
| user-service          | 8082  | Clientes, técnicos, responsáveis            |
| auth-service          | 8081  | Autenticação                                |
| gateway-service       | 8080  | Entrada do sistema                          |
| postgres              | 5432  | Banco relacional — Billing/OS/Usuários      |
| redis                 | 6379  | Cache opcional                              |

**Subir:**

./scripts/dev-billing.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 🔗 Fluxo 8 – Integrações Externas (Integrations Flow)

Este fluxo sobe apenas os serviços necessários para:

- consumir APIs externas  
- enviar dados para sistemas terceiros  
- implementar webhooks de entrada (via gateway)  
- sincronizar dados entre Work Orders e sistemas externos  
- testar integrações internas com serviços de usuários  

**Serviços incluídos:**

| Serviço               | Porta | Função                                         |
|-----------------------|-------|-----------------------------------------------|
| integration-service   | 8088  | Núcleo de integrações externas                 |
| work-order-service    | 8083  | Fonte de dados internos                        |
| user-service          | 8082  | Referência de usuários                         |
| auth-service          | 8081  | Autenticação                                   |
| gateway-service       | 8080  | Entrada / Webhooks                             |
| postgres              | 5432  | Banco relacional para integrações              |
| redis                 | 6379  | Cache opcional                                 |

**Subir:**

./scripts/dev-integrations.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 🛡️ Fluxo 9 – Administrativo (Admin Flow)

Este fluxo sobe os serviços necessários para:

- gestão administrativa completa do sistema  
- dashboards operacionais e gerenciais  
- visão integrada de usuários, OS e KPIs  
- envio de alertas administrativos  
- operações avançadas de gestão  

**Serviços incluídos:**

| Serviço               | Porta | Função                                  |
|-----------------------|-------|------------------------------------------|
| admin-service         | 8089  | Central de administração do sistema      |
| analytics-service     | 8085  | KPIs, dashboards e insights              |
| user-service          | 8082  | Contas e permissões                      |
| work-order-service    | 8083  | Dados operacionais                       |
| notification-service  | 8086  | Alertas administrativos                  |
| auth-service          | 8081  | Autenticação e autorização               |
| gateway-service       | 8080  | Entrada unificada                        |
| postgres              | 5432  | Banco relacional                         |
| redis                 | 6379  | Cache opcional                           |

**Subir:**

./scripts/dev-admin.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 📊 Fluxo 10 – Relatórios (Reporting Flow)

Este fluxo sobe tudo que é necessário para:

- geração de relatórios (PDF, CSV, Excel, JSON)
- relatórios operacionais e gerenciais
- extração de dados consolidados
- relatórios filtrados por técnico, cliente ou período
- dashboards auxiliares

**Serviços incluídos:**

| Serviço               | Porta | Função                                         |
|-----------------------|-------|------------------------------------------------|
| reporting-service     | 8090  | Núcleo de relatórios e exportações            |
| analytics-service     | 8085  | KPIs e dados agregados                         |
| work-order-service    | 8083  | Dados operacionais                             |
| user-service          | 8082  | Dados de usuários                              |
| auth-service          | 8081  | Autenticação                                   |
| gateway-service       | 8080  | API Gateway                                     |
| postgres              | 5432  | Banco relacional                                |
| redis                 | 6379  | Cache opcional                                  |

**Subir:**

./scripts/dev-reporting.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 📡 Fluxo 11 – Mensageria e Eventos (Messaging Flow)

Este fluxo sobe os serviços necessários para:

- processamento assíncrono de eventos
- comunicação entre microserviços via Kafka
- envio e consumo de eventos de Work Orders
- geração de eventos de domínio
- pipelines de eventos para notificações e analytics

**Serviços incluídos:**

| Serviço               | Porta | Função                                       |
|-----------------------|-------|-----------------------------------------------|
| event-router-service  | 8091  | Roteamento e orquestração de eventos          |
| work-order-service    | 8083  | Emissor de eventos de OS                      |
| analytics-service     | 8085  | Consumidor de eventos (KPIs)                  |
| notification-service  | 8086  | Consumidor de eventos (alertas)               |
| user-service          | 8082  | Dados auxiliares                              |
| auth-service          | 8081  | Autenticação                                  |
| gateway-service       | 8080  | Acesso externo                                |
| kafka                 | 9092  | Mensageria                                    |
| zookeeper             | 2181  | Coordenação do Kafka                          |
| postgres              | 5432  | Banco                                         |
| redis                 | 6379  | Cache                                         |

**Subir:**

./scripts/dev-messaging.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 🧭 Fluxo 12 – Configurações e Segredos (Config Flow)

Este fluxo sobe tudo que é necessário para:

- centralização de configurações globais  
- gerenciamento seguro de segredos (DEV)  
- exposição de configs via API  
- isolamento seguro de configurações por ambiente  
- leitura de configs pelo Gateway ou Admin

**Serviços incluídos:**

| Serviço         | Porta | Função                                   |
|-----------------|-------|-------------------------------------------|
| config-service  | 8092  | Centro de configurações / segredos        |
| auth-service    | 8081  | Autenticação                              |
| gateway-service | 8080  | Exposição via API Gateway                 |
| postgres        | 5432  | Banco do auth-service                     |
| redis           | 6379  | Cache                                     |

**Subir:**

./scripts/dev-config.sh
Parar:

Copiar código
./scripts/dev-stop.sh 

### 🌐 Fluxo 13 – Full Dev (todos os microserviços)

Este fluxo sobe **todos os microserviços**, simulando um ambiente completo de desenvolvimento integrado.

Use apenas quando:

- você precisar testar fluxos cruzados complexos  
- validar integrações entre todos os serviços  
- rodar testes de regressão  
- fazer inspeções completas em métricas e comportamento interno

**Atenção:**  
Este fluxo exige **muita RAM e CPU**.  
Recomendado apenas se sua máquina suportar.

**Serviços incluídos:**

- gateway-service  
- auth-service  
- user-service  
- work-order-service  
- file-storage-service  
- analytics-service  
- notification-service  
- billing-service  
- admin-service  
- config-service  
- integration-service  
- reporting-service  
- event-router-service  
- Postgres  
- MongoDB  
- Redis  
- Kafka  
- Zookeeper  

**Subir:**

./scripts/dev-full.sh
Parar:

Copiar código
./scripts/dev-stop.sh 
```bash