package xyz.eddpurcell.example.resttemplateconfig.app.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import xyz.eddpurcell.example.resttemplateconfig.config.common.BaseRestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @ConfigurationProperties("external")
    @Qualifier("external")
    public RestTemplate externalRestTemplate() {
        return new BaseRestTemplate();
    }

    @Bean
    @ConfigurationProperties("internal")
    @Qualifier("internal")
    public RestTemplate internalRestTemplate() {
        return new BaseRestTemplate();
    }
}
