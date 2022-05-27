package com.cfa.jobs.letterjob;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@Slf4j
@RequiredArgsConstructor
@EnableBinding({Source.class})
public class SimpleStep implements Tasklet {

    @Override
    public RepeatStatus execute(final StepContribution stepContribution, final ChunkContext chunkContext) {
        return RepeatStatus.FINISHED;
    }

}
