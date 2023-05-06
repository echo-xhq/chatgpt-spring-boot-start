package org.xhq.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 20:16
 */
@Data
@Component
public class ChatResponse {

    private String id;

    private String object;

    private LocalDate created;

    private List<Choices> choices;

    private Usage usage;
}
