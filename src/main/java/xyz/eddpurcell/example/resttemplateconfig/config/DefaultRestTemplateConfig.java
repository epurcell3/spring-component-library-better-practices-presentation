package xyz.eddpurcell.example.resttemplateconfig.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import xyz.eddpurcell.example.resttemplateconfig.config.common.BaseRestTemplate;

public class DefaultRestTemplateConfig {
    @ConditionalOnCloudPlatform(CloudPlatform.NONE)
    @Bean
    public RestTemplate defaultRestTemplate() {
        return new BaseRestTemplate();
    }

    @ConditionalOnCloudPlatform(CloudPlatform.KUBERNETES)
    @Bean
    public RestTemplate k8sRestTemplate() {
        RestTemplate bean = new BaseRestTemplate();
        // add some networks certs...
        return bean;
    }
}
