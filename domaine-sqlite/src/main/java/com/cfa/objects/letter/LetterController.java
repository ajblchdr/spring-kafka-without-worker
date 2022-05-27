package com.cfa.objects.letter;

import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.sql.Date;

@RestController
@RequestMapping(value = "/letter")
public class LetterController {

    @Autowired
    private LetterRepository letterRepository;

    @GetMapping("/getAll")
    public List<Letter> getAll(){
        return letterRepository.findAll();
    }

    @GetMapping("/getLettersByMessageContains{str}")
    public List<Letter> getLettersByMessageContains(@PathVariable(value="str") final String str){
        return letterRepository.getLettersByMessageContains(str);
    }

    @GetMapping("/getLettersByCreationDate")
    public List<Letter> getLettersByCreationDate(@RequestParam(value="date") final Date date){
        return letterRepository.getLettersByCreationDate(date);
    }

    @GetMapping("/save/{message}")
    public void save(@PathVariable(value="message") final String message){
        Letter l = new Letter();
        l.setMessage(message);
        long now = System.currentTimeMillis();
        l.setCreationDate(new Date(now));
        l.setTreatmentDate(new Date(now));
        letterRepository.save(l);
    }

    @GetMapping("/save")
    public void save(){
        Letter l = new Letter();
        long now = System.currentTimeMillis();
        l.setCreationDate(new Date(now));
        l.setTreatmentDate(new Date(now));
        letterRepository.save(l);
    }

}
