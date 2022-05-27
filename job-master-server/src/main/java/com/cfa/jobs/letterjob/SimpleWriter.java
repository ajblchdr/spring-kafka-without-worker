package com.cfa.jobs.letterjob;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
public class SimpleWriter implements ItemWriter<String> {
    private String url = "http://localhost:9621/letter/save/";

   /* @Override
    public void write(List<String> list) throws Exception {
        for(String s : list){
            System.out.println(s);
        }
    }*/


    @Override
    public void write(List<? extends String> list) throws Exception {
        for(String a : list){
            String result = getResult(a);
            System.out.println(a+" - "+result);
        }
    }

    private String getResult(String message) {
        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url+message, String.class);
    }
}