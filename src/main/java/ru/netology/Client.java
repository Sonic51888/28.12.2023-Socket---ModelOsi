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
            out.printf("Ответ клиента:  GET / HTTP / 1.1. Host: neology.homework\n");
            System.out.println(in.readLine());
            out.println("Александр");
            System.out.println(in.readLine());
            out.println("Тебя как зовут?");
            System.out.println(in.readLine());
            out.println("Очень приятно");
            System.out.println(in.readLine());
            out.println("нет");
        }
    }
}

