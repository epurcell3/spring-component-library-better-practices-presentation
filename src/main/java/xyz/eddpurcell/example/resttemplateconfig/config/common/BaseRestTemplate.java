package xyz.eddpurcell.example.resttemplateconfig.config.common;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class BaseRestTemplate extends RestTemplate {

    private BaseHttpClientConfig httpClientConfig;

    public BaseHttpClientConfig getHttpClientConfig() {
        return httpClientConfig;
    }

    /**
     * A way to be clever with how you name things
     * @param httpClientConfig
     */
    public void setHttpClientConfig(BaseHttpClientConfig httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(this.httpClientConfig.getConnectTimeout());
        requestFactory.setReadTimeout(this.httpClientConfig.getReadTimeout());
        this.setRequestFactory(requestFactory);
    }

    public static class BaseHttpClientConfig {
        private int readTimeout;
        private int connectTimeout;

        public int getReadTimeout() {
            return readTimeout;
        }

        public void setReadTimeout(int readTimeout) {
            this.readTimeout = readTimeout;
        }

        public int getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
        }
    }
}
