package com.evseev.task1.usersComponents;

/**
 * объект Data поле класса User
 */
public class Data {
    private final int id;
    private final String email;
    private final String first_name;
    private final String last_name;
    private final String avatar;

    public Data(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = firstName;
        this.last_name = lastName;
        this.avatar = avatar;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
