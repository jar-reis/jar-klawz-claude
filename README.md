# JAR Klawz Stack — Cloud (Claude) Bootstrap

Container-ready Spring Boot bootstrap for the **Claude** cloud agent variant.

## Quick Start (Local)

```bash
mvn clean package
java -jar target/jar-klawz-claude-*.jar
```

## Quick Start (Docker)

```bash
docker build -t jar-klawz-claude .
docker run -p 8081:8081 -e CLAUDE_API_KEY=$CLAUDE_API_KEY jar-klawz-claude
```

## What It Does

- Imports `klawz-starter` (core auto-configuration)
- In-memory H2 by default (override with `KLAWZ_DB_URL` env var)
- **No shell access** — containers don't have interactive shells
- **Claude as the default LLM provider**
- Spring Boot Actuator health endpoint at `/actuator/health`

## Config

| Key | Default | Description |
|-----|---------|-------------|
| `klawz.provider` | `claude` | AI provider |
| `server.port` | `8081` | HTTP port (override with `PORT` env var) |
| `klawz.claude.api-key` | `${CLAUDE_API_KEY}` | Claude API key (env only) |
| `klawz.claude.model` | `claude-sonnet-4-20250514` | Default model |
| `klawz.shell.enabled` | `false` | Shell access disabled |
| `H2_CONSOLE_ENABLED` | `false` | H2 console (env var) |

## Environment Variables

| Variable | Required | Description |
|----------|----------|-------------|
| `CLAUDE_API_KEY` | Yes | Claude API key |
| `PORT` | No | Server port (default 8081) |
| `KLAWZ_DB_URL` | No | JDBC URL (default in-memory H2) |
| `LOG_LEVEL` | No | Logging level (default INFO) |

## Differences from MBP / Olivier

| | MBP / Olivier | CLAUDE (Cloud) |
|--|---------------|----------------|
| Provider | `kimi` / `claude` | `claude` |
| Shell | Full allowlist | **Disabled** |
| Port | `8080` / `8081` | `8081` (env override) |
| DB | File-backed H2 | In-memory H2 or external |
| Workspace | Local filesystem | Container-ephemeral |
| Profile | `mbp` / `olivier` | `claude` |
| Actuator | No | Yes (`/actuator/health`) |

## Health Check

```bash
curl http://localhost:8081/actuator/health
```

Returns `UP` when all modules are initialized.
