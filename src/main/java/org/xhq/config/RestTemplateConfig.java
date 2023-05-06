package org.xhq.config;

import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 16:15
 */
@Configuration
public class RestTemplateConfig {

    @ConditionalOnMissingBean(RestTemplate.class)
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(getClientHttpRequestFactory());
    }

    /**
     * 使用OkHttpClient作为底层客户端
     * @return
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory(){

//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(500,TimeUnit.SECONDS)
//                .setConnectionRequestTimeout(500,TimeUnit.SECONDS)
//                .build();
//        CloseableHttpClient client = HttpClientBuilder
//                .create()
//                .setDefaultRequestConfig(config)
//                .build();
//        return new HttpComponentsClientHttpRequestFactory(client);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(500, TimeUnit.SECONDS)
                .writeTimeout(500, TimeUnit.SECONDS)
                .readTimeout(500, TimeUnit.SECONDS)
                .proxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("172.0.0.1",7890)))
                .build();
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }
}
