package org.tanyi.seata.config;

import org.apache.seata.common.util.StringUtils;
import org.apache.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.seata.spring.boot.autoconfigure.properties.SeataProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SeataConfig
 * @Description
 * @Auther tanyi
 * @Date 2025/8/11
 * @Version 1.0
 **/
@Configuration
@RequiredArgsConstructor
public class SeataConfig {
    private final ApplicationContext applicationContext;
    private final SeataProperties seataProperties;

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        String applicationName = this.applicationContext.getEnvironment().getProperty("spring.application.name");
        String txServiceGroup = this.seataProperties.getTxServiceGroup();
        if (StringUtils.isEmpty(txServiceGroup)) {
            txServiceGroup = applicationName + "-fescar-service-group";
            this.seataProperties.setTxServiceGroup(txServiceGroup);
        }

        return new GlobalTransactionScanner(applicationName, txServiceGroup);
    }
}
