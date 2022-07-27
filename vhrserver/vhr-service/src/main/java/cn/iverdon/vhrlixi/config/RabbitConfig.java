package cn.iverdon.vhrlixi.config;

import cn.iverdon.vhrlixi.model.MailConstants;
import cn.iverdon.vhrlixi.service.MailSendLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


/**
 * @author iverdon
 * @date 2020/10/7 16:02
 */
@Configuration
public class RabbitConfig {

    public final static Logger logger = LoggerFactory.getLogger(RabbitConfig.class);

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    MailSendLogService mailSendLogService;

    @Bean
    RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setConfirmCallback((data,ack,cause) ->{
            String msgId = data.getId();
            if (ack){
                //消息发送成功
                logger.info(msgId+":消息发送成功");
                mailSendLogService.updateMailSendLogStatus(msgId,1);//修改数据库中的记录，消息投递成功
            }else {
                logger.info(msgId+":消息发送失败");
            }
        });
        rabbitTemplate.setReturnCallback((msg,repCode,repText,exchange,routingkey)->{
            //到路由的时候失败
            logger.info("消息发送失败");
        });
        return rabbitTemplate;
    }

    @Bean
    Queue mailQueue(){
        return new Queue(MailConstants.MAIL_QUEUE_NAME, true);
    }

    @Bean
    DirectExchange mailExchange(){
        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME,true,false);
    }

    @Bean
    Binding mailBinding(){
        return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(MailConstants.MAIL_ROUTING_KEY_NAME);
    }
}
