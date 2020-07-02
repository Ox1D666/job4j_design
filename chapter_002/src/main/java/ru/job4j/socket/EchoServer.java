package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean stopServer = false;
            while (!stopServer) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    do {
                        str = in.readLine();
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            stopServer = true;
                        } else if (str.contains("Hello")) {
                            System.out.println("Hello, dear friend.");
                        } else {
                            System.out.println(str);
                        }
                    }
                    while (!str.isEmpty());
                    out.write("HTTP/1.1 200 OK\r\r\r\n\\".getBytes());
                }
            }
        }
    }
}