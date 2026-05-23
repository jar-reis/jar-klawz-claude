package io.jar.klawz.claude.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Cloud-specific configuration for the CLAUDE bootstrap.
 * Container-ready — no shell access, no local filesystem assumptions.
 */
@Configuration
@Profile("claude")
public class ClaudeConfig {
    // Cloud variant relies on klawz-starter auto-configuration.
    // No shell executor bean — containers don't have interactive shells.
    // No local workspace initializer — uses klawz-workspace LocalFileStore.
}
