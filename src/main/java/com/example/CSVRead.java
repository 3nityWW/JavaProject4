package com.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для чтения данных о людях из CSV-файла.
 */
public class CSVRead {

    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/foreign_names.csv"; // Путь
        char separator = ';'; // Разделитель

        List<People> people = readPeopleFromCSV(csvFilePath, separator);

        // Результат
        for (People person : people) {
            System.out.println(person);
        }
    }

    /**
     * Читает данные о людях из CSV-файла.
     *
     * @param csvFilePath путь к CSV-файлу
     * @param separator   разделитель
     * @return список людей
     */
    public static List<People> readPeopleFromCSV(String csvFilePath, char separator) {
        List<People> people = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(separator) // Разделитель
                        .build())
                .build()) {

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Парсим строку
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                LocalDate birthDate = LocalDate.parse(nextLine[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                String divisionCode = nextLine[4];
                double salary = Double.parseDouble(nextLine[5]);

                // Создаем объекты
                Division division = new Division(divisionCode);
                People person = new People(id, name, gender, division, salary, birthDate);

                // Добавляем в список
                people.add(person);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (CsvException e) {
            System.err.println("Ошибка при чтении CSV: " + e.getMessage());
        }

        return people;
    }
}