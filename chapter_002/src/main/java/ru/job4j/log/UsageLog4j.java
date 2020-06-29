package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Kirill";
        boolean sex = true;
        byte age = 25;
        short weight = 70;
        int height = 180;
        long iq = 10;
        char size = 'M';
        double vision = -3.5;



        LOG.debug("User info name : {}, sex : {}, age : {}, weight : {}"
                + ", heigt : {}, iq : {}, size : {}, vision : {}", name, sex, age, weight, height, iq, size, vision);
    }
}