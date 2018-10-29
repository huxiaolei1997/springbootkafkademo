package com.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @version $Id: KafkaProducer, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2018年10月29日 下午 3:22 胡晓磊 Exp $
 */
@Component
@EnableScheduling
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * kafka 生产者发送消息（每秒生成一条消息）
     * @param
     * @return void
     * @author 胡晓磊
     * @version 1.0
     * @date 2018-10-29 15:23:14
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send() {
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("app_log", message); // 这里的 app_log 是 kafka 中的 topic
        future.addCallback(success -> System.out.println("消息发送成功" + message), throwable -> System.out.println("消息发送失败" + message));
    }
}
