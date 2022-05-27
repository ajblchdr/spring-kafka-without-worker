package com.cfa.remotechunking;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.integration.chunk.RemoteChunkingWorkerBuilder;
import org.springframework.batch.integration.config.annotation.EnableBatchIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
@EnableBatchIntegration
@EnableBatchProcessing
public class WorkerConfiguration {
    @Autowired
    private RemoteChunkingWorkerBuilder workerBuilder;
    @Bean
    public IntegrationFlow workerFlow() {
        ChannelConfig channelConfig = new ChannelConfig();
        return this.workerBuilder
                .itemProcessor(new SimpleProcessor())
                .itemWriter(new SimpleWriter())
                .outputChannel(channelConfig.requests())
                .inputChannel(channelConfig.replies())
                .build();
    }

}

