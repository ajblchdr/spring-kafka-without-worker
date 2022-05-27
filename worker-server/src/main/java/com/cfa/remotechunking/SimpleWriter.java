package com.cfa.remotechunking;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@RequiredArgsConstructor
public class SimpleWriter implements ItemWriter<String> {
   /* @Override
    public void write(List<String> list) throws Exception {
        for(String s : list){
            System.out.println(s);
        }
    }*/

    @Override
    public void write(List<? extends String> list) throws Exception {
        for(String a : list){
            System.out.println(a);
        }
    }
}
