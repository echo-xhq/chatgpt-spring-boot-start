package org.xhq.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 20:19
 */
@Data
@Component
public class Messages {

    private String role = "user";

    private String content;
}
