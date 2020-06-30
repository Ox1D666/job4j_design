package ru.job4j.structures.exam;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;


/**
 * Class for checking the uniqueness of users by email.
 */
public class Post {

//    private List<User> users;

    /**
     * Sort users by email. We take the user and compare the emails of the remaining ones,
     * if there are repetitions, copy from the remaining to the comparable one, delete the remaining one.
     * Take next.
     *
     * @param usersList
     * @return List with uniques users.
     */
    public List<User> parse(List<User> usersList) {
        List<User> users = usersList;
        Set<String> mailsBaseUser = usersList.get(0).getMail();
//        for (int j = 1; j < users.size(); j++) {
//            Set<String> mailsNextUser = usersList.get(j).getMail();
//            for (var baseMail : mailsBaseUser) {
//                for (var nextMail : mailsNextUser) {
//                    if (nextMail.equals(baseMail)) {
//                        //тут надо кинуть в users уникального юзера, дубликаты удалить,
//                        // и запустить поиск дубликатов со следующего уникального юзера
//                    }
//                }
//            }
//        }
        return users;
    }

    public Set<String> compareEmails(Set<String> base, Set<String> next) {
        for (var baseMail : base) {
            for (var nextMail : next) {
                if (nextMail.equals(baseMail)) {
                    System.out.println(2);
                }
            }
        }
        System.out.println(1);
        return base;
    }


    public static class User {
        private String name;
        private Set<String> mail;

        public User(String name, Set<String> mail) {
            this.name = name;
            this.mail = mail;
        }

        public Set<String> getMail() {
            return mail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMail(Set<String> mail) {
            this.mail = mail;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name) && Objects.equals(mail, user.mail);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, mail);
        }

        @Override
        public String toString() {
            return name + " " + mail;
        }
    }
}
