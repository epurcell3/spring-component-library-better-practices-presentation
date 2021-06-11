package xyz.eddpurcell.example.resttemplateconfig.config.annotation;

import org.springframework.context.annotation.Import;
import xyz.eddpurcell.example.resttemplateconfig.config.DefaultRestTemplateConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DefaultRestTemplateConfig.class})
public @interface UseDefaultRestTemplate {
}
