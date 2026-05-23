package io.jar.klawz.claude;

import io.jar.klawz.starter.KlawzCoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KlawzCoreAutoConfiguration.class)
public class KlawzClaudeApplication {
    public static void main(String[] args) {
        SpringApplication.run(KlawzClaudeApplication.class, args);
    }
}
