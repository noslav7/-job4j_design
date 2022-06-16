package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    public static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        char name = 'n';
        int age = 30;
        byte agility = 9;
        short dexterity = 10;
        float charisma = 8.0f;
        double intelligence = 9;
        boolean wisdom = false;
        long distanceCovered = 10_000L;
        LOG.debug("User info name : {}, age : {}, agility : {}, dexterity : {}, charisma : {}, intelligence : {},"
                        + " wisdom : {}, distanceCovered : {}",
                name, age, agility, dexterity, charisma, intelligence, wisdom, distanceCovered);
    }
}
