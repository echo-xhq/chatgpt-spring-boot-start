package org.xhq.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.xhq.dto.ChatRequest;
import org.xhq.dto.ChatResponse;
import org.xhq.dto.Messages;
import org.xhq.entity.Url;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.xhq.properties.ChatGptServiceProperties;
import org.xhq.service.ChatGptService;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 14:22
 */
@Slf4j
@Service
public class ChatGptServiceImpl implements ChatGptService {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    protected ChatGptServiceProperties gptServiceProperties;

    @Override
    public String sendMessage(String question) {
        Messages messages = new Messages();
        ChatRequest request = new ChatRequest();

        messages.setContent(question);
        request.setMessages(messages);
        String jsonString = JSONObject.toJSONString(request);
        log.info("请求体中的数据：{}",jsonString);

        URI uri = UriComponentsBuilder.fromUriString(String.valueOf(Url.CHAT)).build(true).toUri();
        RequestEntity<String> requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", String.format("Bearer %s", gptServiceProperties.getApi_key()))
//                .header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44")
                .body(jsonString);
        log.info("请求的完整数据 {}", requestEntity);

        ResponseEntity<ChatResponse> responseEntity = restTemplate.exchange(requestEntity, ChatResponse.class);
        log.info("响应的数据：{}",responseEntity);

        String content = responseEntity.getBody().getChoices().get(0).getMessages().getContent();

        return content;

    }
}
