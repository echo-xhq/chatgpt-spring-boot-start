package org.xhq.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.xhq.properties.ChatGptServiceProperties;
import org.xhq.service.ChatGptService;
import org.xhq.service.impl.ChatGptServiceImpl;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 14:17
 */
@AutoConfiguration
@ComponentScan(basePackages = {"org.xhq.dto","org.xhq.config"})
@ConditionalOnClass(value = {ChatGptService.class, ChatGptServiceImpl.class})
@EnableConfigurationProperties(ChatGptServiceProperties.class)
public class ChatGptServiceAutoConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public ChatGptService getService() {
            return new ChatGptServiceImpl();
        }

}
