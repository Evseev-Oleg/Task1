package com.evseev.task1.usersComponents;

/**
 * класс-шаблон для парсера JSON строки
 */
public class User {
    private final Data data;
    private final Support support;

    public User(Data data, Support support) {
        this.data = data;
        this.support = support;
    }

    public Data getData() {
        return data;
    }
}
