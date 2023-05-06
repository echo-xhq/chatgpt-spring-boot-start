package org.xhq.service;

import org.springframework.stereotype.Service;

/**
 * @author Echo
 * @version 1.0
 * @description Create by 2023/3/19 14:20
 */
@Service
public interface ChatGptService {

    /**
     * 聊天
     * @param question 提问
     * @return
     */
    String sendMessage(String question);
}
