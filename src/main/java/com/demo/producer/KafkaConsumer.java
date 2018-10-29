package com.demo.producer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @version $Id: KafkaConsumer, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2018年10月29日 下午 3:29 胡晓磊 Exp $
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"app_log"}, groupId = "test")
    public void receive(String content) {
        System.out.println("Receive:" + content);
    }
}
