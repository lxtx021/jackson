package com.jackson.kafka;


import lombok.Data;

import java.util.Date;

/**
 * @author 孙洪波
 * @version 1.0  2018/6/7
 */
@Data
public class Message {
    /**
     * id
     */
    private Long id;
    /**
     * 消息
     */
    private String msg;
    /**
     * 时间戳
     */
    private Date sendTime;
}
