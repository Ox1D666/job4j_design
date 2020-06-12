package ru.job4j.structures.exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class PostTest {
    @Test
    public void whenAddFiveAndTwoIsOriginal() {
        Post post = new Post();
        List<Post.User> users = new ArrayList<>();

        Set<String> user1Mails = new HashSet<>();
        user1Mails.add("xxx@ya.ru"); user1Mails.add("foo@gmail.com"); user1Mails.add("lol@mail.ru");
        Post.User user1 = new Post.User("user1", user1Mails);
        users.add(user1);

        Set<String> user2Mails = new HashSet<>();
        user2Mails.add("foo@gmail.com"); user2Mails.add("ups@pisem.net");
        Post.User user2 = new Post.User("user2", user2Mails);
        users.add(user2);

        Set<String> user3Mails = new HashSet<>();
        user3Mails.add("xyz@pisem.net"); user3Mails.add("vasya@pupkin.com");
        Post.User user3 = new Post.User("user3", user3Mails);
        users.add(user3);

        Set<String> user4Mails = new HashSet<>();
        user4Mails.add("ups@pisem.net"); user4Mails.add("aaa@bbb.ru");
        Post.User user4 = new Post.User("user4", user4Mails);
        users.add(user4);

        Set<String> user5Mails = new HashSet<>();
        user5Mails.add("xyz@pisem.net");
        Post.User user5 = new Post.User("user5", user5Mails);
        users.add(user5);

        List<Post.User> result = post.parse(users);

        List<Post.User> usersExpect = new ArrayList<>();

        Set<String> user1MailsNew = new HashSet<>();
        user1MailsNew.add("xxx@ya.ru"); user1MailsNew.add("foo@gmail.com"); user1MailsNew.add("lol@mail.ru");
        user1MailsNew.add("ps@pisem.net"); user1MailsNew.add("aaa@bbb.ru");
        Post.User user1New = new Post.User("user1", user1MailsNew);
        usersExpect.add(user1New);

        Set<String> user2MailsNew = new HashSet<>();
        user2MailsNew.add("xyz@pisem.net"); user2MailsNew.add("vasya@pupkin.com");
        Post.User user2New = new Post.User("user3", user2MailsNew);
        usersExpect.add(user2New);

        assertThat(result, is(usersExpect));
    }
}