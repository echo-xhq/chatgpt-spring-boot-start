package org.xhq.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 20:12
 */
@Data
@Component
public class ChatRequest {

    private String model = "gpt-3.5-turbo";

    private Messages messages;
}
