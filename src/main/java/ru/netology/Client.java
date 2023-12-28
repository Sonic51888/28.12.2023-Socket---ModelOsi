package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    static final String host = "netology.homework";
    static final String END = "END";

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(host, Server.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            out.printf("Ответ клиента:  GET / HTTP / 1.1. Host: neology.homework\n"); // 1 отправили запрос
            String response = in.readLine();
            System.out.println(response);
            String task = scanner.nextLine();
            out.println(task);//нужна что бы закрыть бесконечный цикл по окончанию работы с сервером
            response = in.readLine();
            System.out.println(response);
            while (!task.equalsIgnoreCase(END)) {
                response = in.readLine(); // 3 приняли запрос и 5 приняли запрос на ребенка или нет
                System.out.println(response);
                task = scanner.nextLine();
                out.println(task);// отпраляем запросы

            }
        }
    }
}
