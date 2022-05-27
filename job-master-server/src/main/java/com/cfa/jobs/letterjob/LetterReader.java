package com.cfa.jobs.letterjob;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;

@Getter
@Setter
@RequiredArgsConstructor
public class LetterReader implements ItemReader<String> {

    private String path = "test.txt";
    private Iterator<String> letters;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return letters.hasNext() ? letters.next() : null;
    }
}
