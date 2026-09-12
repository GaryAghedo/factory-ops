# FactoryOps

FactoryOps is a multi-service industrial operations platform designed to bring together Production, Maintenance, Quality, Inventory, and Operations teams.

The platform enables teams to report operational issues, coordinate work, track equipment and production status, manage inventory, and improve communication across factories, warehouses, and other industrial environments.

Users interact with the platform through mobile devices, including Android and iOS phones and tablets, as well as through a web interface.

FactoryOps also supports AI agents through an MCP server. This allows users to query operational data, investigate production and maintenance issues, retrieve contextual information, and perform approved actions using natural-language interactions.

## Architecture

The backend is built primarily with Scala and follows a functional programming approach using Cats Effect.

Core technologies include:

* Scala
* Cats Effect
* http4s
* Tapir
* Chimney
* Doobie
* PostgreSQL
* OpenSearch
* Redis
* Kafka

The backend follows an API-first architecture using versioned OpenAPI specifications.

OpenAPI contracts define the public API before implementation. Tapir is used to generate API models and endpoint definitions from these contracts, while Chimney is used to transform objects between API, domain, and persistence models.

Doobie provides transactional access to PostgreSQL, which acts as the primary system of record.

OpenSearch provides fast operational search across areas such as production issues, equipment, maintenance records, and quality incidents.

Redis is used for caching, distributed coordination, and short-lived application state where appropriate.

Kafka provides asynchronous communication between backend services and supports event-driven workflows across Production, Maintenance, Quality, Inventory, Search, and other parts of the platform.

## Infrastructure

FactoryOps is designed to run as a cloud-native platform.

Infrastructure is defined and managed using Pulumi, allowing infrastructure configuration to be written as code, reviewed through Git, and deployed consistently across environments.

Backend services are packaged as containers and deployed to Kubernetes.

Kubernetes provides:

* Service deployment and orchestration
* Horizontal scaling
* Service discovery
* Health checks
* Rolling deployments
* Configuration and secret management
* Resilience and automatic workload recovery

Pulumi is used to provision and manage infrastructure such as:

* Kubernetes clusters
* Networking
* PostgreSQL
* OpenSearch
* Redis
* Kafka infrastructure
* Service configuration
* IAM and permissions
* Monitoring infrastructure
* Environment-specific resources

The platform is designed to support multiple environments, for example:

```text
development
staging
production
```

Infrastructure configuration is version controlled alongside the application code.

## CI/CD

GitHub Actions provides the CI/CD pipelines for FactoryOps.

Pull requests run automated checks before changes can be merged, including:

* Compilation
* Unit tests
* Integration tests
* Code formatting
* Static analysis
* OpenAPI contract validation
* API compatibility checks
* Database migration checks
* Container image builds

After changes are merged, GitHub Actions can build and publish versioned container images and trigger deployments to the appropriate Kubernetes environment.

A typical deployment flow is:

```text
Developer
    ↓
Pull Request
    ↓
GitHub Actions
    ↓
Compile + Test + Validate
    ↓
Merge
    ↓
Build Container Image
    ↓
Push Image to Container Registry
    ↓
Pulumi
    ↓
Kubernetes Deployment
    ↓
Development / Staging / Production
```

The goal is to keep both application and infrastructure changes automated, repeatable, reviewable, and safe to deploy.

## AI and MCP Integration

FactoryOps exposes operational capabilities to AI agents through an MCP server.

The MCP layer provides controlled access to platform functionality such as:

* Searching operational issues
* Retrieving equipment information
* Investigating production failures
* Querying maintenance work orders
* Retrieving quality incidents
* Checking inventory availability
* Creating approved operational actions

AI agents operate through the same authorization boundaries as regular users and should not receive unrestricted access to backend systems.

Potentially destructive or operationally sensitive actions can require explicit user approval before execution.

## Design Principles

FactoryOps is built around the following principles:

* API-first development
* Versioned API contracts
* Functional programming
* Clear service boundaries
* Event-driven communication
* Transactional consistency
* Horizontal scalability
* Cloud-native deployment
* Infrastructure as code
* Automated testing and delivery
* Observability
* Secure AI integration
