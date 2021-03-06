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
                        String argument = str.substring(str.lastIndexOf('=') + 1, str.lastIndexOf(' '));
                        String answer = HELLO.equals(argument) ? "Hello" : argument;
                        if (EXIT.equalsIgnoreCase(answer)) {
                            server.close();
                            stopServer = true;
                        }
                        if (!server.isClosed()) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(answer.getBytes());
                        }
                    }
                } catch (IOException e) {
                    LOG.error("I don't know what exception must be hear, beside fileNotFound", e);
                }
            }
        } catch (IOException e) {
            LOG.error("I don't know what exception must be hear, beside fileNotFound", e);
        }
    }
}