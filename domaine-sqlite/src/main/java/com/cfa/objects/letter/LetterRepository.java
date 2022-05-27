package com.cfa.objects.letter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.*;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Integer> {
    List<Letter> getLettersByMessageContains(final String str);
    List<Letter> getLettersByCreationDate(final Date date);
    //List<Letter> getLettersByTreatmentDate(final Date date);
}
