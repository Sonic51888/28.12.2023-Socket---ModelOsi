package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static final int PORT = 8181;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер стартовал");
        while (true) {
            try (
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    Scanner scannerServer = new Scanner(System.in)) {
                String infoFromClient = in.readLine();//2 приняли запрос
                System.out.println(infoFromClient);//2
                out.println("Как тебя зовут?");//2
                final String NAME = in.readLine();//4 приняли имя
                out.printf("Привет %s подключение принято, Ты ребенок? ответить да/нет\n", NAME);
                System.out.println(in.readLine());
                out.println("Добро пожаловать во взрослую зону");
                System.out.println(in.readLine());
                out.println("Сервер Netology");
                System.out.println(in.readLine());
                out.println("Ответ сервера: Остались еще вопросы?");
                System.out.println(in.readLine());
            }
        }
    }
}

