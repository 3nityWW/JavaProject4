package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

class CSVReadTest {

    @Test
    void testReadPeopleFromCSV() {
        String csvFilePath = "src/main/resources/foreign_names.csv";
        char separator = ';';

        List<People> people = CSVRead.readPeopleFromCSV(csvFilePath, separator);

        // Проверяем список на пустоту
        assertNotNull(people);
        assertFalse(people.isEmpty());

        // Проверяем данные первого человека
        People firstPerson = people.get(0);
        assertEquals(28281, firstPerson.getId(), "First ID incorrect");
        assertEquals("Aahan", firstPerson.getName(), "First name incorrect");
        assertEquals("Male", firstPerson.getGender(), "First gender incorrect");
        assertEquals(LocalDate.of(1970, 5, 15), firstPerson.getBirthDate());
        assertEquals("I", firstPerson.getDivision().getCode());
        assertEquals(4800, firstPerson.getSalary(), 0.001);
    }
    
}