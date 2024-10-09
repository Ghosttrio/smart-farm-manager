package com.ghosttrio.smartfarmmanager.controller.batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SlackConfig {

    private final SlackProperties slackProperties;

    @Bean
    public MethodsClient methodsClient() {
        return Slack.getInstance().methods(slackProperties.getToken());
    }
}
