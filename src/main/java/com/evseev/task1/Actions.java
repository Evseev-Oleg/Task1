package com.evseev.task1;

import com.evseev.task1.usersComponents.User;
import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * класс реализующий все действия в программе
 * ввод данных с командной строки
 * получение Response
 * парсер JSON
 * отображение результата
 */
public class Actions {
    private final Scanner scanner = new Scanner(System.in);
    private User user;

    /**
     * метод предлагает ввести данные
     * и выводит ответ
     */
    public void startPage() {
        System.out.println("Enter the user id");
        System.out.print(">");
        int id = scanner.nextInt();
        user = search(id);
        String head = "java <Task1> " + id;
        if (user.getData() != null) {
            String firstName = user.getData().getFirst_name();
            String lastName = user.getData().getLast_name();
            System.out.println(head);
            System.out.println(firstName + " " + lastName);
        } else {
            System.out.println(head);
            System.out.println("User not found");
        }
    }

    /**
     * метод образующий Http(get) запрос
     * преобразует  JSON в объект User
     *
     * @param id введенное значение
     * @return созданный объект User
     */
    public User search(int id) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpUriRequest httpUriRequest = RequestBuilder.get()
                    .setUri(new URI("https://reqres.in/api/users"))
                    .addParameter("id", String.valueOf(id))
                    .build();
            try (CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
                String strResponse = EntityUtils.toString(response.getEntity());
                Gson gson = new Gson();
                user = gson.fromJson(strResponse, User.class);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
