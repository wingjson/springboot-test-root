package com.dist.springbootstarter;

import com.dist.MqRocketmqStarterApplicationTests;
import com.dist.rocketmq.producer.RocketMQMsgListener;
import com.dist.rocketmq.producer.RocketMQProducer;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * Company: 上海数慧系统技术有限公司
 * Department: 数据中心
 * Date: 2021-06-23 9:24
 * Author: zhengja
 * Email: zhengja@dist.com.cn
 * Desc：
 */
public class RocketMQTests extends MqRocketmqStarterApplicationTests {

    @Resource
    RocketMQProducer rocketMQProducer;

    @Resource
    RocketMQMsgListener rocketMQMsgListener;

    @Test
    public void rocketMQProducer_sendMsg(){
        rocketMQProducer.sendMsg("aaa");
    }

    @Test
    public void rocketMQMsgListener_onMessage(){
    }


}