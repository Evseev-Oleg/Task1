package com.evseev.task1.usersComponents;

/**
 * объект Support поле класса User
 */
public class Support {
    private final String url;
    private final String text;

    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
