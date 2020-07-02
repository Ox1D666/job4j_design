package ru.job4j.io.encoding;

import java.io.IOException;

/**
 * Console bot, which answer random phrase from file. Mute when we sent "stop",
 * continue when we sent "continue" and close when we input "exit".
 */
public class StartUI {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        ChatRoom chat = new ChatRoom(input, args[0]);
        chat.init();
    }
}
