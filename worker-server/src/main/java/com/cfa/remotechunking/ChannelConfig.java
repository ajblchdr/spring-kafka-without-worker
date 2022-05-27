package com.cfa.remotechunking;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;

public class ChannelConfig {

    @Bean
    public DirectChannel requests(){
        return new DirectChannel();
    }
    @Bean
    public IntegrationFlow outboundFlow() { return  null;}
    @Bean
    public QueueChannel replies() {
        return new QueueChannel();

    }
    /*
    @Bean
        public IntegrationFlow inboundFlow () { return null}

     */
}

