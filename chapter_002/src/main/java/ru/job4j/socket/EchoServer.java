package ru.job4j.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());
    private static final String HELLO = "Hello";
    private static final String EXIT = "Exit";

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean stopServer = false;
            while (!stopServer) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (str != null) {
                        String msg = str.substring(str.lastIndexOf("=") + 1, str.lastIndexOf(' '));
                        if (msg.equals(HELLO)) {
                            System.out.println("Hello, dear friend");
                        } else if (msg.equals(EXIT)) {
                            server.close();
                            stopServer = true;
                        } else {
                            System.out.println(str);
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\r\r\n\\".getBytes());
                } catch (IOException e) {
                    LOG.error("I don't know what exception must be hear, beside fileNotFound", e);
                }
            }
        } catch (IOException e) {
            LOG.error("I don't know what exception must be hear, beside fileNotFound", e);
        }
    }
}