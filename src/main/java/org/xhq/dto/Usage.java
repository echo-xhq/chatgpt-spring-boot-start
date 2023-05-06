package org.xhq.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 20:23
 */
@Data
@Component
public class Usage {

    private String prompt_tokens;

    private String completion_tokens;

    private String total_tokens;
}
