package xyz.weechang.taroco.service.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.monitoring.NoOpMessageMonitor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * axon 注册
 * @author weechang
 * @date 2017年11月18日23:49:02
 */
@Configuration
public class AxonConfiguration {

    @Bean
    CommandBus commandBus(TransactionManager transactionManager) {
        SimpleCommandBus commandBus = new SimpleCommandBus(transactionManager, NoOpMessageMonitor.INSTANCE);
        commandBus.registerDispatchInterceptor(new BeanValidationInterceptor());
        return commandBus;
    }
}
