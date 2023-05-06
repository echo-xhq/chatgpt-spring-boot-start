package org.xhq.entity;

/**
 * @author Echo
 * @version 1.0
 * @description Create by 2023/3/19 20:07
 */

public enum Url {
    //聊天
    CHAT("https://openai.theinspiredgroup.com/v1/chat/completions");

    /**
     * 请求openAI接口
     */
    private final String url;

    Url(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return this.url;
    }
}
