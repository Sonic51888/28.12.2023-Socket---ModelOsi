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
                out.println("Ответ сервера: Как тебя зовут?");//2
                final String NAME = in.readLine();//4 приняли имя
                out.printf("Ответ сервера: Привет %s подключение принято, Ты ребенок? ответить да/нет\n", NAME);
                while (true) {//6 проверка детской зоны и перевод в общение
                                        infoFromClient = in.readLine();
                    if (infoFromClient.equalsIgnoreCase("да")) {
                        out.println("Ответ сервера: Добро пожаловать в детскую зону");
                        break;
                    } else if (infoFromClient.equalsIgnoreCase("нет")) {
                        out.println("Ответ сервера: Добро пожаловать во взрослую зону");
                        break;
                    } else {
                        out.println("Ответ сервера: Данный вариант отсутствует, повторите еще раз");
                    }
                    break;
                }
                out.println("Ответ сервера: Остались еще вопросы?");
                String serverTask;
                while (true) {
                    infoFromClient = in.readLine();//чтение запроса
                    System.out.println(infoFromClient);
                    serverTask = scannerServer.nextLine();
                    out.println(serverTask);// ответ
                }
            }
        }
    }
}
