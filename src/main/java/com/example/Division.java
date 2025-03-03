package com.example;

/**
 * Класс, представляющий подразделение.
 */
public class Division {
    private static int nextId = 1; // Генератор ID

    private int id;
    private String code; // Код подразделения (одна буква)

    public Division(String code) {
        this.id = nextId++;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}