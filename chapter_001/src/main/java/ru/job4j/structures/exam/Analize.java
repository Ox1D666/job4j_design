package ru.job4j.structures.exam;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        if ((current.size() - previous.size() > 0)) {
            info.added = current.size() - previous.size();
        } else {
            info.deleted = previous.size() - current.size();
        }
        for (var prevEl : previous) {
            for (var curEl : current) {
                if (prevEl.id == curEl.id && !prevEl.name.equals(curEl.name)) {
                    info.changed++;
                }
                if (previous.indexOf(prevEl) >= current.indexOf(curEl)) {
                    break;
                }
            }
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
