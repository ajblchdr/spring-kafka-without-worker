package com.cfa.jobs.letterjob;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;

@RequiredArgsConstructor
public class SimpleProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String letters) throws Exception {
        return  letters.toUpperCase();
    }
}
