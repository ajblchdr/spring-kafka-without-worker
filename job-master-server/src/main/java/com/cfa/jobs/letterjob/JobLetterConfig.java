package com.cfa.jobs.letterjob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Configuration
public class JobLetterConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job1() {
        return jobBuilderFactory.get("jobExample")
                .start(stepOne())
                .build();
    }

    @Bean
    public Step stepOne() {
        LetterReader letterReader = new LetterReader();
        letterReader.setLetters(initData().iterator());
        return stepBuilderFactory.get("stepOne")
                .<String, String>chunk(1)
                .reader(letterReader)
                .processor(new SimpleProcessor())
                .writer(new SimpleWriter())
                .build();
    }

    @Bean
    public Step stepTwo() {
        return stepBuilderFactory.get("stepTwo")
                .tasklet( new SimpleTasklet())
                .build();
    }

    /*@Bean
    public ItemReader<List<String>> readerLetter() {

        return new FlatFileItemReaderBuilder<List<String>>()
                .name("strReader")
                .resource(new ClassPathResource("test.csv"))
                .linesToSkip(1)
                .build();
    }*/

    public List<String> initData(){
        List<String> result = new ArrayList<>();
        try {
            File myObj = new File("test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.add(data);
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }

    /*@Bean
    public ItemReader<List<String>> itemReader() {

        FlatFileItemReader<List<String>> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("test.csv"));
        reader.setLineMapper(new DefaultLineMapper() {{
            setLineTokenizer(new DelimitedLineTokenizer());
            setFieldSetMapper(new PassThroughFieldSetMapper());
        }});
        return reader;
    }*/

}
