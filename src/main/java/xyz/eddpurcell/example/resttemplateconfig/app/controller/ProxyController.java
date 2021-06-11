package xyz.eddpurcell.example.resttemplateconfig.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProxyController {
    private final RestTemplate externalRestTemplate;
    private final RestTemplate internalRestTemplate;

    @Autowired
    public ProxyController(
            @Qualifier("external") RestTemplate externalRestTemplate,
            @Qualifier("internal") RestTemplate internalRestTemplate
    ) {
        this.externalRestTemplate = externalRestTemplate;
        this.internalRestTemplate = internalRestTemplate;
    }

    @GetMapping("/callExample")
    public String callExample() {
        return externalRestTemplate.getForObject("http://www.example.com", String.class);
    }

    @GetMapping("/callInternalExample")
    public String callInternalExample() {
        return internalRestTemplate.getForObject("http://www.example.com", String.class);
    }
}
