package org.xhq.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xhq
 * @version 1.0
 * @description Create by 2023/3/19 13:21
 */
@Component
@ConfigurationProperties(prefix = "xhq.chatgpt")
@Data
public class ChatGptServiceProperties {

    /**
     * openAI的接口秘钥
     */
    private String api_key;

    /**
     * 所使用的的数据模型
     */
    private String model = "gpt-3.5-turbo";

    /**
     * 完成时要生成的最大令牌数,默认16
     * tips:令牌计数不能超过模型的上下文长度。大多数模型的上下文长度为 2048 个令牌（最新模型除外，它支持 4096）
     */
    private int max_tokens = 16;

    /**
     * 使用什么采样温度,默认1
     * tips:介于 0 和 2 之间。较高的值（如 0.8）将使输出更加随机，而较低的值（如 0.2）将使其更加集中和确定。
     *
     * 我们通常建议更改此设置，但不要同时更改两者。top_p
     */
    private int temperature = 1;

    /**
     * 默认值为 1
     * 使用温度采样的替代方法称为核心采样，其中模型考虑具有top_p概率质量的令牌的结果
     * tips:0.1 意味着只考虑包含前 10% 概率质量的代币。我们通常建议更改此设置，但不要同时更改两者。temperature
     */
    private int top_p = 1;

    /**
     * 为每个提示生成的完成次数,默认值为1
     * tips:由于此参数会生成许多完成，因此它会快速消耗令牌配额。请谨慎使用，并确保对 max_token和 stop进行合理的设置。
     */
    private int n = 1;

    /**
     * 默认为 false
     * 是否流式传输回部分进度。如果设置，令牌将在可用时作为纯数据服务器发送的事件发送，流由消息终止。
     */
    private boolean stream = false;
}
